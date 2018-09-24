package cl.ciisa.ee.ejercicio2.to;

import java.io.Serializable;

/**
 * POJO de Curso.
 * 
 * @author psep
 */
public class CursoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private Long valor;
	
	public CursoTO() {
		
	}

	public CursoTO(String nombre, Long valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

}
