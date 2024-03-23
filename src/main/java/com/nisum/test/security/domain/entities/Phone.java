package com.nisum.test.security.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "phones")
public class Phone implements Serializable{
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "number")
    private String number;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "country_code")
    private String countryCode;

    public Phone() {
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getNumber() {
        return number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
