package com.bms.central_api_v1.exception;

public class UnAuthorizedException extends RuntimeException{

    public UnAuthorizedException(String message){
        super(message);
    }
}
