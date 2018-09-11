/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ciisa.ee.diagnostica.delegate;

import cl.ciisa.ee.diagnostica.type.BencinaType;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author psep
 */
public class Calculo {
    
    private long litros;
    private long total;
    
    public long precio(String octanaje) {
        try {
            return BencinaType.getByOctanos(Integer.parseInt(octanaje)).getValor();
        } catch (Exception e) {
            return 0;
        }
    }
    
    public boolean validaCarga(String octanaje, String valor) {
        return !"Seleccione".equals(valor) && !"Seleccione".equals(octanaje);
    }
    
    public void comprobante(JComboBox jComboBoxOctanaje, JComboBox jComboBoxMonto, JLabel jLabelTotalDinero, JLabel jLabelLitros) {
        String octanaje = (String) jComboBoxOctanaje.getSelectedItem();
        String valor = (String) jComboBoxMonto.getSelectedItem();
        
        if (!this.validaCarga(octanaje, valor)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Debe seleccionar Octanaje y Valor a cargar");
        } else {
            String _dinero = (String) jComboBoxMonto.getSelectedItem();
            Integer dinero = Integer.parseInt(_dinero);
            long precio = this.precio((String)jComboBoxOctanaje.getSelectedItem());
            this.litros = this.litros + (dinero / precio);
            this.total = this.total + dinero;
            
            jLabelTotalDinero.setText(this.total + "");
            jLabelLitros.setText(this.litros + "");
        }
    }
    
    public void reset(JLabel jLabelLitros, JLabel jLabelTotalDinero) {
        jLabelLitros.setText("0");
        jLabelTotalDinero.setText("0");
        this.total = 0;
        this.litros = 0;
    }
    
}
