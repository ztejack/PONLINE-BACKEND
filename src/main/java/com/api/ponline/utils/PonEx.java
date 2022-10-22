package com.api.ponline.utils;

import java.util.Base64;

public class PonEx {
    public static void main(String[] args) {
        String originalInput = "test input";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);


        System.out.println(encodedString);
        System.out.println(decodedString);

    }
}
