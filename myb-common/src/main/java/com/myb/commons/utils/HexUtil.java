package com.myb.commons.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class HexUtil {
	private final static String HEX_NUMS_STR = "0123456789ABCDEF";
	private final static Integer SALT_LENGTH = 12;
	
	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] hexChars = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR.indexOf(hexChars[pos + 1]));
		}
		return result;
	}

	public static String byteToHexString(byte[] salt) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < salt.length; i++) {
			String hex = Integer.toHexString(salt[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			hexString.append(hex.toUpperCase());
		}
		return hexString.toString();
	}

	public static boolean validPasswd(String passwd, String dbPasswd) {
		try {
			byte[] pwIndb = hexStringToByte(dbPasswd);
			byte[] salt = new byte[SALT_LENGTH];
			System.arraycopy(pwIndb, 0, salt, 0, SALT_LENGTH);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			md.update(passwd.getBytes("UTF-8"));
			byte[] digest = md.digest();
			byte[] digestIndb = new byte[pwIndb.length - SALT_LENGTH];
			System.arraycopy(pwIndb, SALT_LENGTH, digestIndb, 0, digestIndb.length);
			if (Arrays.equals(digest, digestIndb)) {
				return true;
			} else {
				return false;
			}
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static String getEncryptedPwd(String passwd) {
		try {
			byte[] pwd = null;
			SecureRandom sc = new SecureRandom();
			byte[] salt = new byte[SALT_LENGTH];
			sc.nextBytes(salt);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			md.update(passwd.getBytes("UTF-8"));
			byte[] digest = md.digest();
			pwd = new byte[salt.length + digest.length];
			System.arraycopy(salt, 0, pwd, 0, SALT_LENGTH);
			System.arraycopy(digest, 0, pwd, SALT_LENGTH, digest.length);
			return byteToHexString(pwd);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}