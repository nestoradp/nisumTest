package com.nisum.test.security.application.dto;

import java.util.UUID;

public class PhoneDTO {

  private UUID id;
  private String number;
  private String cityCode;
  private String countryCode;

    public UUID getId() {
        return id;
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
