package com.nisum.test.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NisumConfiguration {

    @Value("${clave.regex}")
    private  String passwordRegex;


    public String getPasswordRegex() {
        return passwordRegex;
    }
}
