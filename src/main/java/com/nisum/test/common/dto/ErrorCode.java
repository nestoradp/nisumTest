package com.nisum.test.common.dto;

public class ErrorCode {

    private final String description;

    public ErrorCode( String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
