package com.dumbaz.skatespot;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {

    private static String passwordToHash;

    public HashMD5(String password) {
        passwordToHash = password;
    }

    public static String getHashPassword()
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return (generatedPassword);
    }
}
