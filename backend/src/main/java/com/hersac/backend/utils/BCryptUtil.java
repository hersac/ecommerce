package com.hersac.backend.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptUtil {

	public static String hashPassword(String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
	}

	public static boolean checkPassword(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}

}
