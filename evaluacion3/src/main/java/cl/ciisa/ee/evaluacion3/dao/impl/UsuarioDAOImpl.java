package cl.ciisa.ee.evaluacion3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Named;

import cl.ciisa.ee.evaluacion3.dao.UsuarioDAO;
import cl.ciisa.ee.evaluacion3.exception.DAOException;
import cl.ciisa.ee.evaluacion3.to.PersonaTO;
import cl.ciisa.ee.evaluacion3.to.UsuarioTO;
import cl.ciisa.ee.evaluacion3.util.HashUtil;

/**
 * @author psep
 *
 */
@Named("usuarioDAO")
public class UsuarioDAOImpl extends BaseDAOImpl implements UsuarioDAO {

	@Override
	public UsuarioTO get(Integer id) throws DAOException {
		return null;
	}

	@Override
	public List<UsuarioTO> listAll() throws DAOException {
		return null;
	}

	@Override
	public Boolean create(UsuarioTO e) throws DAOException {
		return null;
	}

	@Override
	public Boolean update(UsuarioTO e) throws DAOException {
		return null;
	}

	@Override
	public Boolean delete(UsuarioTO e) throws DAOException {
		return null;
	}

	@Override
	public UsuarioTO getUser(UsuarioTO user) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UsuarioTO usuario = null;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT u.idUsuario, u.username, u.passwd, p.idPersona, p.rut, p.dvRut, p.nombre, p.apellidos ");
			sql.append("FROM Usuario u INNER JOIN Persona p ON u.Persona_idPersona = p.idPersona ");
			sql.append("WHERE u.username = ? AND u.passwd = ? ");
			
			conn = super.getConnection();
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, user.getUsername());
			ps.setString(2, HashUtil.getHash(user.getPasswd()));
			rs = ps.executeQuery();
			
			if (rs.next()) {
				usuario = new UsuarioTO();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setUsername(user.getUsername());
				
				PersonaTO persona = new PersonaTO();
				persona.setIdPersona(rs.getInt("idPersona"));
				persona.setRut(rs.getInt("rut"));
				persona.setDv(rs.getString("dvRut"));
				persona.setNombre(rs.getString("nombre"));
				persona.setApellidos(rs.getString("apellidos"));
				usuario.setPersona(persona);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			super.closeAll(ps, rs, conn);
		}
		
		return usuario;
	}

}
