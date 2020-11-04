package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNotFindException extends RuntimeException {
    public UserNotFindException(String message){
        super(message);
    }
}
