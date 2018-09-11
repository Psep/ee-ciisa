package cl.ciisa.ee.ejercicio1.utils;

import cl.ciisa.ee.ejercicio1.type.SeveridadType;

/**
 * Clase utilitaria para la generación de html.
 * 
 * @author psep
 *
 */
public final class HtmlUtil {
	
	/**
	 * Genera mensajes dinámicos según severidad.
	 * 
	 * @param severidad
	 * @param message
	 * @return
	 */
	public static final String getMessage(SeveridadType severidad, String message) {
		String cssClass = "<div class=\"alert %s alert-dismissible fade show\" role=\"alert\">";
		StringBuilder alert = new StringBuilder();
		
		if (severidad.equals(SeveridadType.ERROR)) {
			alert.append(String.format(cssClass, "alert-danger"));
			alert.append("<strong>Error!</strong><br>");
		} else if (severidad.equals(SeveridadType.INFO)) {
			alert.append(String.format(cssClass, "alert-success"));
			alert.append("<strong>Info!</strong> ");
		}
		
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
		builder.append("<!doctype html><html>");
		builder.append(
				"<head><meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		builder.append(
				"<meta name=\"author\" content=\"Pablo Sepúlveda\"><title>Formulario de Ingreso - Ejercicio 1</title>");
		builder.append(
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		builder.append("</head><body><div class=\"container\">");
		builder.append(body);
		builder.append(
				"</div><footer><script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X);965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH);8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>");
		builder.append(
				"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV);2);9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>");
		builder.append(
				"<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3);MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>");
		builder.append("</footer></body></html>");

		return builder.toString();
	}

}
