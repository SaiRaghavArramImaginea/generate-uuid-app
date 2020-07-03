package com.pramati.generator;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UUIDGenerator {
	
	
	public static String generateUUID(String data, int length) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
        md.reset();
        md.update(data.getBytes("UTF-8"));
        byte[] hashedData = md.digest();

        String hexStr = "";
        String alphaHex = "";
        for (int i = 0; i < hashedData.length; i++) {
        	hexStr +=  Integer.toString(hashedData[i], 34).substring(1);
        	alphaHex  += (char)(Math.abs(hexStr.hashCode())%26+65);
        }
        return hexStr.substring(0, length);
  }
}
