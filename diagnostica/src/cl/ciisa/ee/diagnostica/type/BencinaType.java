/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ciisa.ee.diagnostica.type;

/**
 *
 * @author psep
 */
public enum BencinaType {

    OCT_93(93, 700), 
    OCT_95(95, 750), 
    OCT_97(97, 800);
    
    private int octanos;
    private long valor;
    
    private BencinaType(int octanos, long valor) {
        this.octanos = octanos;
        this.valor = valor;
    }

    public int getOctanos() {
        return octanos;
    }

    public long getValor() {
        return valor;
    }
    
    public static BencinaType getByOctanos(int octanos) throws Exception{
        for (BencinaType type : BencinaType.values()) {
            if (octanos == type.getOctanos()) {
                return type;
            }
        }
        
        throw new Exception("No se encuentra octanaje!");
    }
    
}
