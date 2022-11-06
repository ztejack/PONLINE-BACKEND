package com.api.ponline.dto.user;

import javax.validation.constraints.NotBlank;

 
public class ResetPasswordRequest {
    @NotBlank
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}
