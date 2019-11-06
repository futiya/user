package com.ibm.user.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
@Slf4j
public class EncrytedPasswordUtils {

	public static String encrytePassword(String password) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder.encode(password);
	}

	public static boolean matchPassword(String password, String hashpassword) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder.matches(password, hashpassword);
	}

	public static void main(String[] args) {
		log.info(EncrytedPasswordUtils.encrytePassword("123456"));
	}

}
