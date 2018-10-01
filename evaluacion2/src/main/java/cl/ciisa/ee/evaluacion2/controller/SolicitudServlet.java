package cl.ciisa.ee.evaluacion2.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ciisa.ee.evaluacion2.model.Cliente;
import cl.ciisa.ee.evaluacion2.model.Solicitud;
import cl.ciisa.ee.evaluacion2.model.TelefoniaHogar;
import cl.ciisa.ee.evaluacion2.model.TelevisionHogar;

/**
 * Servlet implementation class SolicitudServlet
 * 
 * @author psep
 */
@WebServlet("/solicitar.do")
public class SolicitudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final long ADICIONAL = 5000l;

	/**
	 * Constructor del servlet.
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public SolicitudServlet() {
		super();
	}

	/**
	 * Método GET por defecto del servlet. Redirige al index por acceso sólo
	 * mediante POST.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
	
	/**
	 * @param solicitud
	 */
	private void calcular(Solicitud solicitud) {
		if (solicitud.getCantInstTv() < 2) {
			solicitud.setAdicionalInstalacion(0l);
		} else {	
			int diff = solicitud.getCantInstTv() - 2;
			solicitud.setAdicionalInstalacion(diff * ADICIONAL);
		}
		
		long planFono = 0l;
		long planTv = 0l;
		
		if (solicitud.getTelefoniaHogar() != null) {
			planFono = solicitud.getTelefoniaHogar().getValor();
		}
		
		if (solicitud.getTelevisionHogar() != null) {
			planTv = solicitud.getTelevisionHogar().getValor();
		}
		
		solicitud.setTotal(solicitud.getAdicionalInstalacion() + planFono + planTv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Solicitud solicitud = new Solicitud();
		solicitud.setCliente(new Cliente());
		solicitud.getCliente().setRut(request.getParameter("rut"));
		solicitud.getCliente().setNombre(request.getParameter("nombre"));
		solicitud.getCliente().setApellido(request.getParameter("apellido"));
		solicitud.setFechaInstalacion(request.getParameter("fecInstalacion"));
		solicitud.setCantInstTv(0);
		
		String telefonia = request.getParameter("telefonia");
		
		if (telefonia != null && !"".equals(telefonia)) {
			solicitud.setTelefoniaHogar(new TelefoniaHogar().findById(Long.valueOf(request.getParameter("telefonia"))));
		}
		
		String television = request.getParameter("television");
		
		if (television != null && !"".equals(television)) {
			solicitud.setCantInstTv(Integer.parseInt(request.getParameter("instalaciones")));
			solicitud.setTelevisionHogar(new TelevisionHogar().findById(Long.valueOf(request.getParameter("television"))));
		}

		this.calcular(solicitud);
		
		request.setAttribute("solicitudIngresada", solicitud);
		request.getRequestDispatcher("detalle.jsp").forward(request, response);
	}

}
