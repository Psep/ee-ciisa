package cl.ciisa.ee.evaluacion1.delegate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import cl.ciisa.ee.evaluacion1.to.IngresoTO;

/**
 * @author psep
 *
 */
@Named("descuentoDelegate")
public class DescuentoDelegate {
	
	/**
	 * @param ingreso
	 * @return
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
