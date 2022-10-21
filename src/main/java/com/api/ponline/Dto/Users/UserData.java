package com.api.ponline.Dto.Users;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserData {

    @NotEmpty(message = "Name is required")
    private String fullName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email not valid")
    private String email;

    @NotEmpty(message = "Password is required")
    private String password;

    @NotEmpty(message = "Role is required")
    private String userRole;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
}
