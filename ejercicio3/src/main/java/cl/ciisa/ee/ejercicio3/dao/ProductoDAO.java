package cl.ciisa.ee.ejercicio3.dao;

import java.util.List;

import cl.ciisa.ee.ejercicio3.exception.DAOException;
import cl.ciisa.ee.ejercicio3.to.ProductoTO;

public interface ProductoDAO extends GenericDAO<ProductoTO, Integer> {
	
	public List<ProductoTO> listByNombre(String nombre) throws DAOException;

}
