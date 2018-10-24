package cl.ciisa.ee.evaluacion3.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author psep
 *
 */
public final class HashUtil {

	private static final Logger logger = Logger.getLogger(HashUtil.class.getName());

	public static final String getHash(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(text.getBytes());
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < array.length; ++i) {
				builder.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}

			return builder.toString();

		} catch (NoSuchAlgorithmException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);

			return null;
		}
	}

}
