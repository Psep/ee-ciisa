package cl.ciisa.ee.evaluacion1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase con utilitarios varios.
 * 
 * @author psep
 */
public final class GenericUtil {
	
	/**
	 * Método estático que permite la transformación de un objeto
	 * de tipo Date en un String mediante SimpleDateFormat y el patrón
	 * 'yyyy-MM-dd'. En caso de excepción, retornará null.
	 * 
	 * @param date
	 * @return String
	 */
	public static final String dateToString(Date date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Método estático que permite la transformación de un objeto
	 * de tipo String en un Date mediante SimpleDateFormat y el patrón
	 * 'yyyy-MM-dd'. En caso de excepción por String nulo o error de formato,
	 * este retornará null.
	 * 
	 * @param fecha
	 * @return Date
	 */
	public static final Date stringToDate(String fecha) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = format.parse(fecha);
	        return date;
		} catch (ParseException e) {
			return null;
		}
	}

}
