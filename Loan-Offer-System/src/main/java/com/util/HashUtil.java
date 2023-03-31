package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class HashUtil {
    static Logger logger = Logger.getLogger(HashUtil.class.getName());
    public static String getHashCode(String str) {
        String hashCode = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0;i<digest.length;i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }
            hashCode = hexString.toString();
        }catch (NoSuchAlgorithmException exception){
            logger.info("An error occured in getHashCode :"+exception.toString());
        }
        return hashCode;
    }
}
