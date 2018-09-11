package cl.ciisa.ee.ejercicio1.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase de utilitarios para validaciones varias.
 * 
 * @author psep
 *
 */
public final class ValidationUtil {
	
	/**
	 * Valida formato de fechas y que estas tengan coherencia
	 * (fecha de fin debe ser mayor a la de inicio).
	 * 
	 * @param inicio
	 * @param fin
	 * @return
	 */
	public static final boolean validaFechas(String inicio, String fin) {
		boolean validacion = false;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date fInicio = format.parse(inicio);
			Date fTermino = format.parse(fin);
            
			if (fInicio.before(fTermino)) {
				validacion = true;
			}
			
		} catch (Exception e) {}
		
		return validacion;
	}

	/**
	 * Valida el RUT chileno bajo formato XXXXXXXX-X
	 * 
	 * @param rut
	 * @return
	 */
	public static final boolean validaRut(String rut) {
		boolean validacion = false;
		
		try {
			rut = rut.toUpperCase();
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);
			int m = 0, s = 1;
			
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (Exception e) {}
		
		return validacion;
	}

}
