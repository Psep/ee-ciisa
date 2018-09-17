package cl.ciisa.ee.evaluacion1.utils;

import java.util.ArrayList;
import java.util.Iterator;

import cl.ciisa.ee.evaluacion1.to.IngresoTO;
import cl.ciisa.ee.evaluacion1.type.SeveridadType;

/**
 * Utilitarios varios para generar código HTML como String.
 * 
 * @author psep
 */
public final class HtmlUtil {
	
	/**
	 * Método estático que permite la generación de una tabla simple
	 * en bootstrap a partir de un ArrayList de tipo IngresoTO. En caso
	 * de ser nula o vacía la lista, la tabla tendrá una indicación de
	 * que no hay registros (reservas) disponibles.
	 * 
	 * @param lista
	 * @return String
	 */
	public static final String generateTable(ArrayList<IngresoTO> lista) {
		StringBuilder table = new StringBuilder();
		table.append("<table class=\"table\">");
		table.append("<thead><tr>");
		table.append("<th scope=\"col\">Vuelo</th>");
		table.append("<th scope=\"col\">Ida</th>");
		table.append("<th scope=\"col\">Vuelta</th>");
		table.append("<th scope=\"col\">Precio</th>");
		table.append("<th scope=\"col\">Descuento</th>");
		table.append("<th scope=\"col\">Precio c/desc.</th>");
		table.append("</tr></thead>");
		table.append("<tbody>");
		
		if (lista == null || lista.size() == 0) {
			table.append("<tr><td><td colspan=\"6\">No se encuentran reservas.</td></td></tr>");
		} else {
			Iterator<IngresoTO> it = lista.iterator();
			
			while (it.hasNext()) {
				IngresoTO ingreso = it.next();
				table.append("<tr><td>");
				table.append(ingreso.getVuelo().getNombre());
				table.append("</td>");
				table.append("<td>");
				table.append(GenericUtil.dateToString(ingreso.getFechaIda()));
				table.append("</td>");
				table.append("<td>");
				table.append(getNull(GenericUtil.dateToString(ingreso.getFechaVuelta())));
				table.append("</td>");
				table.append("<td>$");
				table.append(ingreso.getVuelo().getValor());
				table.append("</td>");
				table.append("<td>");
				table.append(ingreso.getDescuento());
				table.append("%</td>");
				table.append("<td>$");
				table.append(ingreso.getValorConDescuento());
				table.append("</td></tr>");
			}
		}
		
		table.append("</tbody></table>");
		
		return table.toString();
	}
	
	/**
	 * Método estático que recibe un String y en caso de ser null,
	 * reemplazará este valor por un "". Usado para la generación
	 * de código HTML.
	 * 
	 * @param value
	 * @return String
	 */
	public static final String getNull(String value) {
		return (value == null) ? "" : value;
	}
	
	/**
	 * Genera mensajes dinámicos según severidad.
	 * 
	 * @param severidad
	 * @param message
	 * @return
	 */
	public static final String getMessage(SeveridadType severidad, String title, String message) {
		String cssClass = "<div class=\"alert %s alert-dismissible fade show\" role=\"alert\">";
		StringBuilder alert = new StringBuilder();
		
		if (severidad.equals(SeveridadType.ERROR)) {
			alert.append(String.format(cssClass, "alert-danger"));
		} else if (severidad.equals(SeveridadType.INFO)) {
			alert.append(String.format(cssClass, "alert-success"));
		}
		
		alert.append("<strong>");
		alert.append(title);
		alert.append(":</strong> ");
		alert.append(message);
		alert.append("</div>");
		
		return alert.toString();
	}
	
	/**
	 * Genera la estructura html del header y footer.
	 * 
	 * @param body
	 * @return
	 */
	public static final String getBody(String body) {
		StringBuilder builder = new StringBuilder();
		builder.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\">");
		builder.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		builder.append("<meta name=\"description\" content=\"Reserva de Vuelos para la Evaluación 1\">");
		builder.append("<meta name=\"keywords\" content=\"evaluacion1, reserva de vuelos, ciisa\">");
		builder.append("<meta name=\"author\" content=\"Pablo Sepúlveda\">");
		builder.append("<link rel=\"icon\" href=\"https://getbootstrap.com/favicon.ico\">");
		builder.append("<title>Evaluación 1 - Ciisa</title>");
		builder.append("<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">");
		builder.append("<link rel=\"stylesheet\" href=\"assets/css/main.css\">");
		builder.append("<script src=\"assets/js/jquery-3.3.1.slim.min.js\"></script>");
		builder.append("<script src=\"assets/js/popper.min.js\"></script>");
		builder.append("<script src=\"assets/js/bootstrap.min.js\"></script>");
		builder.append("</head><body>");
		builder.append("<div class=\"d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow\">");
		builder.append("<h5 class=\"my-0 mr-md-auto font-weight-normal\">");
		builder.append("<a href=\"index.html\" title=\"Reserva de Vuelos\">Reserva de Vuelos</a></h5>");
		builder.append("<nav class=\"my-2 my-md-0 mr-md-3\">");
		builder.append("<a class=\"p-2 text-dark\" href=\"index.html\">Inicio</a>");
		builder.append("<a class=\"p-2 text-dark\" href=\"ingreso.do\">Reservas Ingresadas</a></nav>");		
		builder.append("</div><div class=\"container\"><div class=\"row\">");		
		builder.append(body);
		builder.append("</div></div></body></html>");

		return builder.toString();
	}

}
