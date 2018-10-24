package cl.ciisa.ee.evaluacion3.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ciisa.ee.evaluacion3.dao.UsuarioDAO;
import cl.ciisa.ee.evaluacion3.to.UsuarioTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.jsp")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

	@Inject
	private UsuarioDAO usuarioDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("usuario") != null) {
			response.sendRedirect("index.jsp");
		} else {
			request.getRequestDispatcher("ingreso.jsp").forward(request, response);
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logoutAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		this.doGet(request, response);
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loginAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");

		try {
			if (username == null || passwd == null || "".equals(username) || "".equals(passwd)) {
				throw new Exception("¡Debe ingresar usuario y contraseña!");
			} else {
				UsuarioTO usuario = new UsuarioTO();
				usuario.setUsername(username);
				usuario.setPasswd(passwd);
				usuario = this.usuarioDAO.getUser(usuario);

				if (usuario == null) {
					throw new Exception("¡Usuario y/o contraseña no son válidos!");
				} else {
					request.getSession().setAttribute("usuario", usuario);
					response.sendRedirect("index.jsp");
				}
			}

		} catch (Exception e) {
			request.setAttribute("errorMessage", e.getMessage());
			this.doGet(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("btnLogout") != null) {
			this.logoutAction(request, response);
		} else {
			this.loginAction(request, response);
		}
	}

}
