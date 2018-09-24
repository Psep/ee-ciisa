package cl.ciisa.ee.ejercicio2.servlet;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ciisa.ee.ejercicio2.bean.SimuladorBean;
import cl.ciisa.ee.ejercicio2.to.CotizacionTO;
import cl.ciisa.ee.ejercicio2.type.CursoType;
import cl.ciisa.ee.ejercicio2.util.HtmlUtil;

/**
 * Servlet implementation class SimuladorServlet
 * 
 * @author psep
 */
@WebServlet("/simular.do")
public class SimuladorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Inject
    private SimuladorBean simuladorBean;
	
    /**
     * Constructor del servlet.
     * 
     * @see HttpServlet#HttpServlet()
     */
    public SimuladorServlet() {
        super();
    }

	/**
	 * Método GET por defecto del servlet. Redirige al index por acceso sólo
	 * mediante POST.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}
	
	/**
	 * Método que permite la consulta de los precios, descuentos,
	 * adicionales y pago total de la cotización; para luego armar
	 * la estructura visible HTML del resultado.
	 * 
	 * @param cotizacion
	 * @return String
	 */
	private String getCotizacion(CotizacionTO cotizacion) {
		Long precio = this.simuladorBean.precio(cotizacion);
		Integer descuento = this.simuladorBean.descuento(cotizacion);
		Long adicional = this.simuladorBean.adicional(cotizacion);
		Long pago = this.simuladorBean.pago(precio, descuento, adicional);
		
		StringBuilder builder = new StringBuilder();
		builder.append("<div class=\"cotizacion\">");
		builder.append("<h4>Resultados de la Cotización</h4>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"rut\" class=\"col-sm-2 col-form-label\">RUT Cotizante</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<input type=\"text\" id=\"rut\" class=\"form-control\" name=\"rut\" value=\"");
		builder.append(cotizacion.getRut());
		builder.append("\" readonly></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"capacitacion\" class=\"col-sm-2 col-form-label\">Capacitación</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<input type=\"text\" class=\"form-control\" id=\"capacitacion\" value=\"");
		builder.append(cotizacion.getCurso().getNombre());
		builder.append("\" readonly></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"coffeeBreak\" class=\"col-sm-2 col-form-label\">Coffee Break</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<input type=\"text\" class=\"form-control\" id=\"coffeeBreak\" value=\"");
		builder.append(cotizacion.getCoffeeBreak().booleanValue() ? "Sí" : "No");
		builder.append("\" readonly></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"fechaInicio\" class=\"col-sm-2 col-form-label\">Fecha de Inicio</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<input type=\"text\" id=\"fechaInicio\" class=\"form-control\" value=\"");
		builder.append(cotizacion.getFechaInicio());
		builder.append("\" readonly></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"asistentes\" class=\"col-sm-2 col-form-label\">Asistentes</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<input type=\"text\" id=\"asistentes\" class=\"form-control\" value=\"");
		builder.append(cotizacion.getAsistentes());
		builder.append("\" readonly></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"precio\" class=\"col-sm-2 col-form-label\">Precio</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<div class=\"input-group mb-3\">");
		builder.append("<div class=\"input-group-prepend\">");
		builder.append("<span class=\"input-group-text\">$</span>");
		builder.append("</div>");
		builder.append("<input type=\"text\" class=\"form-control\" id=\"precio\" value=\"");
		builder.append(precio);
		builder.append("\" readonly></div></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"descuento\" class=\"col-sm-2 col-form-label\">Descuento</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<input type=\"text\" id=\"descuento\" class=\"form-control\" value=\"");
		builder.append(descuento);
		builder.append("%\" readonly></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"adicional\" class=\"col-sm-2 col-form-label\">Adicional</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<div class=\"input-group mb-3\">");
		builder.append("<div class=\"input-group-prepend\">");
		builder.append("<span class=\"input-group-text\">$</span>");
		builder.append("</div>");
		builder.append("<input type=\"text\" id=\"adicional\" class=\"form-control\" value=\"");
		builder.append(adicional);
		builder.append("\" readonly></div></div></div>");
		builder.append("<div class=\"form-group row\">");
		builder.append("<label for=\"pago\" class=\"col-sm-2 col-form-label\">Pago Total</label>");
		builder.append("<div class=\"col-sm-10\">");
		builder.append("<div class=\"input-group mb-3\">");
		builder.append("<div class=\"input-group-prepend\">");
		builder.append("<span class=\"input-group-text\">$</span>");
		builder.append("</div>");
		builder.append("<input type=\"text\" class=\"form-control\" id=\"pago\" value=\"");
		builder.append(pago);
		builder.append("\" readonly></div></div></div>");
		builder.append("<a href=\"index.jsp\" class=\"btn btn-primary\">Volver</a>");
		builder.append("</div>");
		
		return builder.toString();
	}

	/**
	 * Método POST del servlet. Carga los datos provenientes del JSP para
	 * crear instancia de Cotización y armar los resultados de la simulación.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		CotizacionTO cotizacion = new CotizacionTO();
		cotizacion.setAsistentes(Integer.parseInt(request.getParameter("cantidad")));
		cotizacion.setCoffeeBreak(new Boolean(request.getParameter("coffeeBreak")));
		cotizacion.setCurso(CursoType.getCurso(Long.valueOf(request.getParameter("capacitacion"))));
		cotizacion.setFechaInicio(request.getParameter("fIinicio"));
		cotizacion.setRut(request.getParameter("rut"));
		
		response.setCharacterEncoding("utf-8");
        response.getWriter().append(HtmlUtil.getBody(this.getCotizacion(cotizacion)));
	}

}
