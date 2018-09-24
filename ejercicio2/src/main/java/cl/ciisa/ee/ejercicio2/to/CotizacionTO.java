package cl.ciisa.ee.ejercicio2.to;

import java.io.Serializable;

/**
 * POJO del formulario de Cotización
 * 
 * @author psep
 */
public class CotizacionTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String rut;
	private CursoTO curso;
	private Boolean coffeeBreak;
	private String fechaInicio;
	private Integer asistentes;

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public CursoTO getCurso() {
		return curso;
	}

	public void setCurso(CursoTO curso) {
		this.curso = curso;
	}

	public Boolean getCoffeeBreak() {
		return coffeeBreak;
	}

	public void setCoffeeBreak(Boolean coffeeBreak) {
		this.coffeeBreak = coffeeBreak;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Integer getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(Integer asistentes) {
		this.asistentes = asistentes;
	}

}
