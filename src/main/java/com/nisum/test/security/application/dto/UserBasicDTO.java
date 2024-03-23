package com.nisum.test.security.application.dto;

import java.util.Date;
import java.util.UUID;

public class UserBasicDTO {
    private UUID id;
    private Date createdAt;
    private Date updatedAt;
    private Date lastLogin;
    private String token;

    private boolean isActive;

    public UUID getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public String getToken() {
        return token;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
