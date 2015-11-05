package com.lorren.util;

import java.util.UUID;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class SecurityUtils {
    
    private SecurityUtils() {}
    
    public static String encodePassword(String rawPass) {
        return MD5.encodePassword(rawPass);
    }
    
    public static String generateToken() {
        return Token.generateToken();
    }
    
    public static void main(String[] args) {
        System.out.println(MD5.encodePassword("lorrenpassword"));
    }
}

class Token {
    
    public static String generateToken() {
        return UUID.randomUUID().toString().concat("-").concat(String.valueOf(System.currentTimeMillis()));
    }
}

class MD5 {
    private static Md5PasswordEncoder md5 = new Md5PasswordEncoder();
//    private static final String MD5_SALT = "AbCdEfGhIjKlMnOpQrStUvWxYz-=.,;'[]`";
    private static final String MD5_SALT = "lorren";
    
    public static String encodePassword(String rawPass) {
        return md5.encodePassword(rawPass, MD5_SALT);
    }
    
    public static boolean isPasswordValid(String encPass, String rawPass) {
        return md5.isPasswordValid(encPass, rawPass, MD5_SALT);
    }
}
