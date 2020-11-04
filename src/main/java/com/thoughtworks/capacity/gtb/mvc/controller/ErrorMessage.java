package com.thoughtworks.capacity.gtb.mvc.controller;

import lombok.Data;

@Data
public class ErrorMessage {
    private String message;
    private String statusCode;

    public ErrorMessage(String statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
