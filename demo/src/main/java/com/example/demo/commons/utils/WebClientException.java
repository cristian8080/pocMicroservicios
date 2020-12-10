package com.example.demo.commons.utils;

public class WebClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String code;

    public WebClientException(String message) {
        super(message);
    }

    public WebClientException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}


