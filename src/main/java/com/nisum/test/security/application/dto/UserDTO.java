package com.nisum.test.security.application.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


import java.util.List;
import java.util.UUID;

public class UserDTO {

    private UUID id;
     @NotNull(message = "Name is required")
    private String name;
    @NotNull(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email")
    private String email;
    @NotNull(message = "Password is required")
    private String password;
    private boolean isActive;
    private List<PhoneDTO> phones;

    private String token;

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

    public List<PhoneDTO> getPhones() {
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

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
