package cl.ciisa.ee.ejercicio1;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ciisa.ee.ejercicio1.type.AdicionalType;
import cl.ciisa.ee.ejercicio1.type.CapacidadType;
import cl.ciisa.ee.ejercicio1.type.PagoType;
import cl.ciisa.ee.ejercicio1.type.SeveridadType;
import cl.ciisa.ee.ejercicio1.utils.HtmlUtil;
import cl.ciisa.ee.ejercicio1.utils.ValidationUtil;

/**
 * @author psep
 * 
 * Servlet implementation class IngresoServlet
 */
@WebServlet(name = "ingresoServlet", urlPatterns = { "/" })
public class IngresoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger("IngresoServlet");

	/**
	 * Constructor del servlet
	 */
	public IngresoServlet() {
		super();
	}

	/**
	 * Recibe y conforma el formulario web mediante petición GET.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(HtmlUtil.getBody(this.getForm("", "", "1", "1", "2", "", "")));
	}

	/**
	 * Recibe los parámetros del formulario mediante POST y realiza
	 * validaciones de datos.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuilder body = new StringBuilder();
		String rut = request.getParameter("rut");
		String nombre = request.getParameter("nombre");
		String adicionales = request.getParameter("adicionales");
		String pago = request.getParameter("pago");
		String capacidad = request.getParameter("capacidad");
		String fechaArribo = request.getParameter("fechaArribo");
		String fechaRetirada = request.getParameter("fechaRetirada");
		String errores = "";
		
		if (!ValidationUtil.validaRut(rut)) {
			errores += "El RUT ingresado no es válido.<br>";
		}
		
		if (!ValidationUtil.validaFechas(fechaArribo, fechaRetirada)) {
			errores += "Las fechas de arribo y/o retirada no son válidas o la fecha de retirada no está antes que la de arribo.";
		}
		
		if (!"".equals(errores)) {
			body.append(HtmlUtil.getMessage(SeveridadType.ERROR, errores));
			body.append(this.getForm(rut, nombre, adicionales, pago, capacidad, fechaArribo, fechaRetirada));
		} else { 
			body.append(HtmlUtil.getMessage(SeveridadType.INFO, "¡Datos enviados con éxito!"));
			body.append("<br><a href=\"/ejercicio1/ingreso\" class=\"btn btn-primary\">Volver</a>");
		}
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().append(HtmlUtil.getBody(body.toString()));
	}
	
	/**
	 * Genera el formulario inicial y retorna como String.
	 * 
	 * @param rut
	 * @param nombre
	 * @param adicionales
	 * @param pago
	 * @param capacidad
	 * @param inicio
	 * @param fin
	 * @return
	 */
	private String getForm(String rut, String nombre, String adicionales, String pago, String capacidad, String inicio, String fin) {
		String option = "<option value=\"%s\" %s>%s</option>";
		
		StringBuilder body = new StringBuilder();
		body.append("<h1>Formulario de Reserva de Cabaña Turística</h1>");
		body.append("<form method=\"post\" action=\"#\">");
		body.append("<div class=\"form-group\"><label for=\"rut\">Ingrese su RUT</label>");
		body.append(
				"<input name=\"rut\" id=\"rut\" type=\"text\" class=\"form-control\" placeholder=\"11111111-1\" size=\"10\" maxlength=\"10\"");
		body.append("value=\"");
		body.append(rut);
		body.append("\" required></div>");
		body.append("<div class=\"form-group\"><label for=\"nombre\">Ingrese su Nombre Completo</label>");
		body.append(
				"<input name=\"nombre\" id=\"nombre\" class=\"form-control\" type=\"text\" placeholder=\"Pepito Los Palotes\" size=\"60\" maxlength=\"60\" ");
		body.append("value=\"");
		body.append(nombre);
		body.append("\" required></div>");
		body.append("<div class=\"form-group\"><label for=\"adicionales\">¿Desea servicios adicionales?</label>");
		body.append("<select name=\"adicionales\" id=\"adicionales\" class=\"form-control\">");
		
		for (AdicionalType type : AdicionalType.values()) {
			body.append(String.format(option, type.getId(), (type.getId() == Integer.parseInt(adicionales) ? " selected" : ""), type.getName()));
		}

		body.append("</select></div>");
		body.append("<div class=\"form-group\"><label for=\"pago\">Forma de Pago</label> ");
		body.append("<select name=\"pago\" id=\"pago\" class=\"form-control\">");
		
		for (PagoType type : PagoType.values()) {
			body.append(String.format(option, type.getId(), (type.getId() == Integer.parseInt(adicionales) ? " selected" : ""), type.getName()));
		}
		
		body.append("</select></div>");
		body.append("<div class=\"form-group\"><label for=\"capacidad\">Capacidad de la cabaña</label> ");
		body.append("<select name=\"capacidad\" id=\"capacidad\" class=\"form-control\">");
		
		for (CapacidadType type : CapacidadType.values()) {
			body.append(String.format(option, type.getId(), (type.getId() == Integer.parseInt(adicionales) ? " selected" : ""), type.getName()));
		}
		
		body.append("</select></div>");
		body.append("<div class=\"form-group\"><label for=\"fechaArribo\">Fecha de Arribo</label>");
		body.append("<input name=\"fechaArribo\" id=\"fechaArribo\" class=\"form-control\" type=\"date\" ");
		body.append("value=\"");
		body.append(inicio);
		body.append("\" required></div>");
		body.append("<div class=\"form-group\"><label for=\"fechaRetirada\">Fecha de Retirada</label>");
		body.append("<input name=\"fechaRetirada\" id=\"fechaRetirada\" class=\"form-control\" type=\"date\" ");
		body.append("value=\"");
		body.append(fin);
		body.append("\" required></div>");
		body.append("<button type=\"submit\" class=\"btn btn-primary\">Enviar</button></form>");
		
		return body.toString();
	}

}
