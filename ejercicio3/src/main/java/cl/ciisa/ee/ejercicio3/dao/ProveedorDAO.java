package cl.ciisa.ee.ejercicio3.dao;

import java.util.List;

import cl.ciisa.ee.ejercicio3.exception.DAOException;
import cl.ciisa.ee.ejercicio3.to.ProveedorTO;

public interface ProveedorDAO extends GenericDAO<ProveedorTO, Integer> {
	
	public List<ProveedorTO> listByProductos(Integer idProducto) throws DAOException;

}
