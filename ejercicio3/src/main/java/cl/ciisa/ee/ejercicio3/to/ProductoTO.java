package cl.ciisa.ee.ejercicio3.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductoTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idProducto;
	private String nombre;
	private String descripcion;
	private Integer precio;
	private List<ProveedorTO> proveedores;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public List<ProveedorTO> getProveedores() {
		if (this.proveedores == null) {
			this.proveedores = new ArrayList<>();
		}
		
		return proveedores;
	}

	public void setProveedores(List<ProveedorTO> proveedores) {
		this.proveedores = proveedores;
	}
	
	public String toStringProveedores() {
		StringBuilder builder = new StringBuilder();
		
		if (this.proveedores != null) {
			Iterator<ProveedorTO> it = this.proveedores.iterator();
			
			while (it.hasNext()) {
				ProveedorTO proveedor = (ProveedorTO) it.next();
				builder.append(proveedor.getNombre());
				builder.append("<br>");
			}
		}
		
		
		return builder.toString();
	}

}
