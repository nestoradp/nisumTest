package com.nisum.test.security.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="users")
public class User implements Serializable {
   @Id
   @GenericGenerator(name = "uuid2", strategy = "uuid2")
   @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(name = "name")
   private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private boolean isActive;
    @Column(name = "last_login")
    private Date lastLogin;
    @Column(name = "token")
    private String token;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Phone> phones;

    public User(UUID id, String name, String email, String password, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public String getToken() {
        return token;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
