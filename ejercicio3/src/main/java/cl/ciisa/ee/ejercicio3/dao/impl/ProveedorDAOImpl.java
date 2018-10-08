package cl.ciisa.ee.ejercicio3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

import cl.ciisa.ee.ejercicio3.dao.ProveedorDAO;
import cl.ciisa.ee.ejercicio3.exception.DAOException;
import cl.ciisa.ee.ejercicio3.to.ProveedorTO;

@Named("proveedorDAO")
public class ProveedorDAOImpl extends BaseDAOImpl implements ProveedorDAO {

	@Override
	public ProveedorTO get(Integer id) throws DAOException {
		return null;
	}

	@Override
	public List<ProveedorTO> listAll() throws DAOException {
		List<ProveedorTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT idProveedor, nombre FROM Proveedor";
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ProveedorTO proveedor = new ProveedorTO();
				proveedor.setIdProveedor(rs.getInt("idProveedor"));
				proveedor.setNombre(rs.getString("nombre"));
				
				list.add(proveedor);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			super.closeAll(ps, rs, conn);
		}
		
		return list;
	}

	@Override
	public Boolean create(ProveedorTO t) throws DAOException {
		return null;
	}

	@Override
	public Boolean update(ProveedorTO t) throws DAOException {
		return null;
	}

	@Override
	public Boolean delete(ProveedorTO t) throws DAOException {
		return null;
	}

	@Override
	public List<ProveedorTO> listByProductos(Integer idProducto) throws DAOException {
		List<ProveedorTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT p.idProveedor, p.nombre FROM ProductoProveedor pp INNER JOIN Proveedor p ");
			sql.append("ON  pp.idProveedor = p.idProveedor WHERE pp.idProducto = ?");
			
			conn = super.getConnection();
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, idProducto);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ProveedorTO proveedor = new ProveedorTO();
				proveedor.setIdProveedor(rs.getInt("idProveedor"));
				proveedor.setNombre(rs.getString("nombre"));
				
				list.add(proveedor);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			super.closeAll(ps, rs, conn);
		}
		
		return list;
	}

}
