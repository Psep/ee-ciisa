package cl.ciisa.ee.evaluacion3.dao;

import java.io.Serializable;
import java.util.List;

import cl.ciisa.ee.evaluacion3.exception.DAOException;

/**
 * @author psep
 *
 * @param <E>
 * @param <ID>
 */
public interface GenericDAO<E, ID extends Serializable> {
	
	public E get(ID id) throws DAOException;
	public List<E> listAll() throws DAOException;
	public Boolean create(E e) throws DAOException;
	public Boolean update(E e) throws DAOException;
	public Boolean delete(E e) throws DAOException;

}
