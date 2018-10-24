package cl.ciisa.ee.evaluacion3.dao;

import cl.ciisa.ee.evaluacion3.exception.DAOException;
import cl.ciisa.ee.evaluacion3.to.UsuarioTO;

/**
 * @author psep
 *
 */
public interface UsuarioDAO extends GenericDAO<UsuarioTO, Integer> {
	
	public UsuarioTO getUser(UsuarioTO user) throws DAOException;

}
