package cl.ciisa.ee.ejercicio2.bean;

import javax.inject.Named;

import cl.ciisa.ee.ejercicio2.to.CotizacionTO;

/**
 * Clase que permite calcular precios y descuentos
 * para la simulación de la cotización de cursos.
 * 
 * @author psep
 */
@Named("simuladorBean")
public class SimuladorBean {
	
	/**
	 * Valor por defecto del coffee break adicional.
	 */
	private static final Long COFFEE_BREAK = 1000l;
	
	/**
	 * Según requerimiento: devuelve el precio del
	 * curso al servlet.
	 * 
	 * @param cotizacion
	 * @return precio
	 */
	public Long precio(CotizacionTO cotizacion) {	
		return cotizacion.getAsistentes() * cotizacion.getCurso().getValor();
	}
	
	/**
	 * Según requerimiento: devuelve el porcentaje
	 * del descuento.
	 * 
	 * @param cotizacion
	 * @return descuento
	 */
	public Integer descuento(CotizacionTO cotizacion) {
		if (cotizacion.getAsistentes() < 4) {
			return 0;
		} else if (cotizacion.getAsistentes() < 11) {
			return 7;
		} else if (cotizacion.getAsistentes() < 15) {
			return 10;
		} else {
			return 15;
		}
	}
	
	/**
	 * Según requerimiento: devuelve el valor del
	 * servicio adicional (coffee break)
	 * 
	 * @param cotizacion
	 * @return adicional
	 */
	public Long adicional(CotizacionTO cotizacion) {
		if (!cotizacion.getCoffeeBreak()) {
			return 0l;
		} else {
			return cotizacion.getAsistentes() * COFFEE_BREAK;
		}
	}
	
	/**
	 * Según requerimiento: devuelve el monto total
	 * a pagar
	 * 
	 * @param cotizacion
	 * @return pago
	 */
	public Long pago(Long precio, Integer descuento, Long adicional) {
		return (precio - (precio * descuento / 100)) + adicional;
	}

}
