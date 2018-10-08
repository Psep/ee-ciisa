package cl.ciisa.ee.ejercicio3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Named;

import cl.ciisa.ee.ejercicio3.dao.ProductoDAO;
import cl.ciisa.ee.ejercicio3.exception.DAOException;
import cl.ciisa.ee.ejercicio3.to.ProductoTO;
import cl.ciisa.ee.ejercicio3.to.ProveedorTO;

@Named("productoDAO")
public class ProductoDAOImpl extends BaseDAOImpl implements ProductoDAO {

	@Override
	public ProductoTO get(Integer id) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductoTO producto = null;
		
		try {
			String sql = "SELECT idProducto, nombre, descripcion, precio FROM Producto WHERE idProducto = ?";
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				producto = new ProductoTO();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getInt("precio"));
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			super.closeAll(ps, rs, conn);
		}
		
		return producto;
	}

	@Override
	public List<ProductoTO> listAll() throws DAOException {
		return null;
	}

	@Override
	public Boolean create(ProductoTO producto) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean resultado = false;
		
		try {
			String sql = "INSERT INTO Producto (idProducto, nombre, descripcion, precio) VALUES (?, ?, ?, ?)";
			
			conn = super.getConnection();
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, producto.getIdProducto());
			ps.setString(2, producto.getNombre());
			ps.setString(3, producto.getDescripcion());
			ps.setInt(4, producto.getPrecio());
			ps.executeUpdate();
			
			sql = "INSERT INTO ProductoProveedor (idProducto, idProveedor) VALUES (?, ?)";
			Iterator<ProveedorTO> it = producto.getProveedores().iterator();
			
			while (it.hasNext()) {
				ProveedorTO proveedor = it.next();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, producto.getIdProducto());
				ps.setInt(2, proveedor.getIdProveedor());
				ps.executeUpdate();
			}
			
			conn.commit();
			
			resultado = true;
			
		} catch (SQLException e) {
			super.rollback(conn);
			throw new DAOException(e);
		} finally {
			super.closeAll(ps, rs, conn);
		}
		
		return resultado;
	}

	@Override
	public Boolean update(ProductoTO e) throws DAOException {
		return null;
	}

	@Override
	public Boolean delete(ProductoTO e) throws DAOException {
		return null;
	}

	@Override
	public List<ProductoTO> listByNombre(String nombre) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProductoTO> productos = new ArrayList<>();
		
		try {
			String sql = "SELECT idProducto, nombre, descripcion, precio FROM Producto WHERE nombre like ?";
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + nombre + "%");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				ProductoTO producto = new ProductoTO();
				producto.setIdProducto(rs.getInt("idProducto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setDescripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getInt("precio"));
				productos.add(producto);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			super.closeAll(ps, rs, conn);
		}
		
		return productos;
	}

}
