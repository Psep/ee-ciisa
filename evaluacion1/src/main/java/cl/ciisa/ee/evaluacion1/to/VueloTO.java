package cl.ciisa.ee.evaluacion1.to;

import java.io.Serializable;

/**
 * POJO para los datos relacionados al vuelo.
 * 
 * @author psep
 */
public class VueloTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private Long valor;

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
