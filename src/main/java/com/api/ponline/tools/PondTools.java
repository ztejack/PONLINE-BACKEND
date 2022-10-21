package com.api.ponline.tools;

import java.util.Base64;

public class PondTools {
    public static String encodeBase4(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes()).toString();
    }
}
