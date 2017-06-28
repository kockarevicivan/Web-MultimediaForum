package Commons.Security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityHelper {
	public static String getHash(String pass) {
		String hashed = null;

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte[] data = pass.getBytes();
			m.update(data, 0, data.length);
			BigInteger i = new BigInteger(1, m.digest());
			hashed = String.format("%1$032X", i);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashed;
	}
}
