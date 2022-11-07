package com.api.ponline.model.Entity.user;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Buat Entiti Users
@Entity
@Table(name = "TAB_USER")
public class User implements Serializable{

    // Field Entiti User
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cfvdcbqnjl", nullable = false)
    private Long id;

    @Column(name = "ggxafwykfd" ,nullable = false)
    private String name;

    @Email
    @Column(name = "tbfewjerbs", nullable = false)
    private String email;

    @Column(name = "kwbrftpgtm")
    private String imageUrl;

    @Column(name = "lfcmfluvud", nullable = false)
    private Boolean emailVerified = false;

    @Column(name = "xvfeeumirr", length = 64)
    private String tokEmailVerified;

    @JsonIgnore
    @Column(name = "jtixhfcdmv")
    private String password;

    @Column(name = "typyhbwqgm", length = 64)
    private String tokResetPassword;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ccuombbxii")
    private AuthProvider provider;

    @Column(name = "oebwazzvdi")
    private String providerId;

    @Column(name = "uwegexwxuf", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Setter Getter Field Entiti User
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getTokEmailVerified() {
        return tokEmailVerified;
    }

    public void setTokEmailVerified(String tokEmailVerified) {
        this.tokEmailVerified = tokEmailVerified;
    }

    public String getTokResetPassword() {
        return tokResetPassword;
    }

    public void setTokResetPassword(String tokResetPassword) {
        this.tokResetPassword = tokResetPassword;
    }
    
}
