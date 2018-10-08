package cl.ciisa.ee.ejercicio3.to;

import java.io.Serializable;
import java.util.List;

public class ProveedorTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idProveedor;
	private String nombre;
	private List<ProductoTO> productos;

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ProductoTO> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoTO> productos) {
		this.productos = productos;
	}

}
