package cl.ciisa.ee.ejercicio3.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ciisa.ee.ejercicio3.dao.ProductoDAO;
import cl.ciisa.ee.ejercicio3.dao.ProveedorDAO;
import cl.ciisa.ee.ejercicio3.exception.DAOException;
import cl.ciisa.ee.ejercicio3.to.ProductoTO;
import cl.ciisa.ee.ejercicio3.to.ProveedorTO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index.jsp")
public class IndexServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(IndexServlet.class.getName());
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorDAO proveedorDAO;
	
	@Inject
	private ProductoDAO productoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			List<ProveedorTO> proveedores = this.proveedorDAO.listAll();
			request.setAttribute("proveedores", proveedores);
			
		} catch (DAOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			request.setAttribute("errorMessage", e.getMessage());
		}
		
		request.getRequestDispatcher("addProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			Integer codigo = Integer.valueOf(request.getParameter("codigo"));
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			Integer precio = Integer.valueOf(request.getParameter("precio"));
			String[] proveedores = request.getParameterValues("proveedores");
			
			if (!this.validateProduct(codigo)) {
				request.setAttribute("codigo", codigo);
				request.setAttribute("nombre", nombre);
				request.setAttribute("descripcion", descripcion);
				request.setAttribute("precio", precio);
				request.setAttribute("errorMessage", "El código de producto ingresado ya existe.");
			} else {
				ProductoTO producto = new ProductoTO();
				producto.setIdProducto(codigo);
				producto.setDescripcion(descripcion);
				producto.setNombre(nombre);
				producto.setPrecio(precio);
				
				for (String item : proveedores) {
					ProveedorTO proveedor = new ProveedorTO();
					proveedor.setIdProveedor(Integer.valueOf(item));
					producto.getProveedores().add(proveedor);
				}
				
				if (!this.productoDAO.create(producto)) {
					throw new DAOException("Error al crear el producto!");
				} else {
					request.setAttribute("sucessMessage", "Producto registrado con éxito.");
				}
			}
			
		} catch (DAOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			request.setAttribute("errorMessage", e.getMessage());
		}
		
		doGet(request, response);
	}
	
	private boolean validateProduct(Integer codigo) throws DAOException {
		ProductoTO producto = this.productoDAO.get(codigo);
		
		if (producto == null) {
			return true;
		} else {
			return false;
		}
	}

}
