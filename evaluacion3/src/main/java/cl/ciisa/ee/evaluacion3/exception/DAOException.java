package cl.ciisa.ee.evaluacion3.exception;

import java.sql.SQLException;

/**
 * @author psep
 *
 */
public class DAOException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(SQLException e) {
		super(e);
	}

	public DAOException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return String.format("Error con Base de Datos! %s", super.getMessage());
	}

}
