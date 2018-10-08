package cl.ciisa.ee.ejercicio3.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

/**
 * Servlet implementation class BusquedaServlet
 */
@WebServlet("/buscar.jsp")
public class BusquedaServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(BusquedaServlet.class.getName());
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorDAO proveedorDAO;
	
	@Inject
	private ProductoDAO productoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("searchProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			String opcion = request.getParameter("tipoBusqueda");
			String busqueda = request.getParameter("busqueda");
			List<ProductoTO> productos = null;
			
			if ("porCodigo".equals(opcion)) {
				ProductoTO producto = this.productoDAO.get(Integer.valueOf(busqueda));
				
				if (producto != null) {
					producto.setProveedores(this.proveedorDAO.listByProductos(producto.getIdProducto()));
					productos = new ArrayList<>();
					productos.add(producto);
				}
				
				request.setAttribute("infoMessage", "Busqueda para el código: " + busqueda);
			} else if ("porNombre".equals(opcion)) {
				productos = this.productoDAO.listByNombre(busqueda);
				
				Iterator<ProductoTO> it = productos.iterator();
				
				while (it.hasNext()) {
					ProductoTO producto = it.next();
					producto.setProveedores(this.proveedorDAO.listByProductos(producto.getIdProducto()));
				}
				
				request.setAttribute("infoMessage", "Busqueda con el nombre: " + busqueda);
			} else {
				request.setAttribute("errorMessage", "Debe seleccionar una opción válida!");
			}
			
			request.setAttribute("busqueda", busqueda);
			request.setAttribute("productos", productos);
			
		} catch (NumberFormatException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			request.setAttribute("errorMessage", "Código no válido!");
		} catch (DAOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			request.setAttribute("errorMessage", e.getMessage());
		}
		
		doGet(request, response);
	}

}
