package cl.ciisa.ee.ejercicio2.util;


/**
 * Utilitarios varios para generar código HTML como String.
 * 
 * @author psep
 */
public final class HtmlUtil {
	
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
		builder.append("<meta name=\"description\" content=\"Simulador de Cotizaciones de Cursos en Ejercicio 2\">");
		builder.append("<meta name=\"keywords\" content=\"ejercicio2, cursos, cotizacion, ciisa\">");
		builder.append("<meta name=\"author\" content=\"Pablo Sepúlveda\">");
		builder.append("<link rel=\"icon\" href=\"https://getbootstrap.com/favicon.ico\">");
		builder.append("<title>Ejercicio 2 - Ciisa</title>");
		builder.append("<link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">");
		builder.append("<link rel=\"stylesheet\" href=\"assets/css/main.css\">");
		builder.append("<script src=\"assets/js/jquery-3.3.1.slim.min.js\"></script>");
		builder.append("<script src=\"assets/js/popper.min.js\"></script>");
		builder.append("<script src=\"assets/js/bootstrap.min.js\"></script>");
		builder.append("</head><body>");
		builder.append("<div class=\"d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow\">");
		builder.append("<h5 class=\"my-0 mr-md-auto font-weight-normal\">");
		builder.append("<a href=\"index.jsp\" title=\"Simulador de Cotización para Capacitaciones\">Simulador de Cotización para Capacitaciones</a></h5>");
		builder.append("<nav class=\"my-2 my-md-0 mr-md-3\">");
		builder.append("<a class=\"p-2 text-dark\" href=\"index.jsp\">Inicio</a></nav>");		
		builder.append("</div><div class=\"container\">");
		builder.append(body);
		builder.append("</div></body></html>");

		return builder.toString();
	}

}
