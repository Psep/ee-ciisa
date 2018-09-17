package cl.ciisa.ee.evaluacion1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author psep
 *
 */
public final class GenericUtil {
	
	/**
	 * @param date
	 * @return
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
	 * @param fecha
	 * @return
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
