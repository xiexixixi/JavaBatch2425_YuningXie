package com.example.javabatchspringdemo.Exception;

public class SystemException extends RuntimeException{
    private int code;
    public SystemException(String message, int code){
        super(message);
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
