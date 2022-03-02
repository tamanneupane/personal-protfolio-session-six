package com.tamanneupane.personalprotfolio.exceptions;

import lombok.Getter;

public class ServiceNotFoundException extends RuntimeException {

    @Getter
    private int statusCode;
    @Getter
    private String message;

    public ServiceNotFoundException(int statusCode, String message){
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }
}
