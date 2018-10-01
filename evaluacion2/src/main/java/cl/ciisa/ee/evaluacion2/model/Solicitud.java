package cl.ciisa.ee.evaluacion2.model;

import java.io.Serializable;
import javax.enterprise.inject.Model;

@Model
public class Solicitud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private TelefoniaHogar telefoniaHogar;
	private TelevisionHogar televisionHogar;
	private Integer cantInstTv;
	private Long adicionalInstalacion;
	private String fechaInstalacion;
	private Long total;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TelefoniaHogar getTelefoniaHogar() {
		return telefoniaHogar;
	}

	public void setTelefoniaHogar(TelefoniaHogar telefoniaHogar) {
		this.telefoniaHogar = telefoniaHogar;
	}

	public TelevisionHogar getTelevisionHogar() {
		return televisionHogar;
	}

	public void setTelevisionHogar(TelevisionHogar televisionHogar) {
		this.televisionHogar = televisionHogar;
	}

	public String getFechaInstalacion() {
		return fechaInstalacion;
	}

	public void setFechaInstalacion(String fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}

	public Integer getCantInstTv() {
		return cantInstTv;
	}

	public void setCantInstTv(Integer cantInstTv) {
		this.cantInstTv = cantInstTv;
	}

	public Long getAdicionalInstalacion() {
		return adicionalInstalacion;
	}

	public void setAdicionalInstalacion(Long adicionalInstalacion) {
		this.adicionalInstalacion = adicionalInstalacion;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
