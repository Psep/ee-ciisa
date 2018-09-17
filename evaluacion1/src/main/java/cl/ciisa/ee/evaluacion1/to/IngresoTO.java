package cl.ciisa.ee.evaluacion1.to;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO que homologa el ingreso de una reserva
 * de viaje.
 * 
 * @author psep
 */
public class IngresoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VueloTO vuelo;
	private Date fechaIda;
	private Date fechaVuelta;
	private Integer descuento;
	private Long valorConDescuento;
	
	/**
	 * Constructor vacío por defecto.
	 */
	public IngresoTO() {
		
	}

	/**
	 * Constructor sobrecargado.
	 * 
	 * @param vuelo
	 * @param fechaIda
	 * @param fechaVuelta
	 */
	public IngresoTO(VueloTO vuelo, Date fechaIda, Date fechaVuelta) {
		super();
		this.vuelo = vuelo;
		this.fechaIda = fechaIda;
		this.fechaVuelta = fechaVuelta;
	}

	public VueloTO getVuelo() {
		return vuelo;
	}

	public void setVuelo(VueloTO vuelo) {
		this.vuelo = vuelo;
	}

	public Date getFechaIda() {
		return fechaIda;
	}

	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}

	public Date getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	public Long getValorConDescuento() {
		return valorConDescuento;
	}

	public void setValorConDescuento(Long valorConDescuento) {
		this.valorConDescuento = valorConDescuento;
	}

}
