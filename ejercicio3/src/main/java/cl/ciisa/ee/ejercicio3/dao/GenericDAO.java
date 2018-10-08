package cl.ciisa.ee.ejercicio3.dao;

import java.io.Serializable;
import java.util.List;

import cl.ciisa.ee.ejercicio3.exception.DAOException;

public interface GenericDAO<E, ID extends Serializable> {
	
	public E get(ID id) throws DAOException;
	public List<E> listAll() throws DAOException;
	public Boolean create(E e) throws DAOException;
	public Boolean update(E e) throws DAOException;
	public Boolean delete(E e) throws DAOException;

}
