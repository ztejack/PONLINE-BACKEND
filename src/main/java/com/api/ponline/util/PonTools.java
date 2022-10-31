package com.api.ponline.util;

public class PonTools {
    private String ponlineEmail = "fredihermawan1211@gmail.com";

    private String ponlineBaseUrl = "http://localhost:8080";

    public String genLink(String linkTarget) {
        return ponlineBaseUrl+linkTarget;
    }

    public String getPonlineEmail() {
        return ponlineEmail;
    }

    public void setPonlineEmail(String ponlineEmail) {
        this.ponlineEmail = ponlineEmail;
    }

    public String getPonlineBaseUrl() {
        return ponlineBaseUrl;
    }

    public void setPonlineBaseUrl(String ponlineBaseUrl) {
        this.ponlineBaseUrl = ponlineBaseUrl;
    }
       
}
