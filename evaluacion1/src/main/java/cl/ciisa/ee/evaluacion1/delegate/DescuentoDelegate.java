package cl.ciisa.ee.evaluacion1.delegate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import cl.ciisa.ee.evaluacion1.to.IngresoTO;

/**
 * Bean que permite calcular los descuentos definidos
 * en la pauta de evaluación.
 * 
 * @author psep
 */
@Named("descuentoDelegate")
public class DescuentoDelegate {
	
	/**
	 * Método que permite identificar el descuento correspondiente
	 * basado en las siguientes reglas de negocio: Si la fecha de ida del 
	 * viaje es inferior a 60 días, corresponde al 0% de descuento aplicado;
	 * si la fecha de ida del viaje está entre 61 y 90 días, corresponde
	 * al 10% de descuento aplicado; finalmente, si la fecha de ida del 
	 * viaje está entre 91 y 120 días, corresponde el 15% de descuento aplicado.
	 * <br>
	 * @param ingreso
	 * @return IngresoTO
	 */
	public IngresoTO getDescuento(IngresoTO ingreso) {
		long diff = ingreso.getFechaIda().getTime() - new Date().getTime();
	    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
		if (days > 60 && days < 91) {
			ingreso.setDescuento(10);
		} else if (days > 90) {
			ingreso.setDescuento(15);
		} else {
			ingreso.setDescuento(0);
		}
		
		long valorAdescontar = ingreso.getVuelo().getValor() * ingreso.getDescuento() / 100;
		ingreso.setValorConDescuento(ingreso.getVuelo().getValor() - valorAdescontar);
		
		return ingreso;
	}

}
