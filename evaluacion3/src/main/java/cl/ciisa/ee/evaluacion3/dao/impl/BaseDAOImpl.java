package cl.ciisa.ee.evaluacion3.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import cl.ciisa.ee.evaluacion3.config.Property;
import cl.ciisa.ee.evaluacion3.exception.DAOException;

/**
 * @author psep
 *
 */
@Named
@Dependent
public abstract class BaseDAOImpl {

	@Inject
	@Property("db.username")
	private String username;

	@Inject
	@Property("db.password")
	private String password;

	@Inject
	@Property("db.host")
	private String host;

	@Inject
	@Property("db.port")
	private String port;

	@Inject
	@Property("db.dbname")
	private String dbName;

	/**
	 * Retorna la instancia de conexión según configuración
	 * del dao.properties
	 * 
	 * @return connection
	 * @throws SQLException
	 */
	protected Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = String.format("jdbc:mysql://%s:%s/%s?useSSL=false", this.host, this.port, this.dbName);
			Connection conn = DriverManager.getConnection(url, this.username, this.password);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new DAOException("No se encuentra el driver jdbc!");
		}
	}

	/**
	 * Permite rollback en una transacción.
	 * 
	 * @param conn
	 */
	protected void rollback(Connection conn) {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
		}

	}

	/**
	 * Cierra las conexiones.
	 * 
	 * @param ps
	 * @param rs
	 * @param conn
	 */
	protected void closeAll(PreparedStatement ps, ResultSet rs, Connection conn) {
		try {
			if (ps != null) {
				ps.close();
			}

			if (rs != null) {
				rs.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
		}
	}

}
