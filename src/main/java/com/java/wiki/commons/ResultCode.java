package com.java.wiki.commons;

import lombok.Getter;


public enum ResultCode implements StatusCode {

    SUCCESS(1000,"request success"),
    FAIL(1001,"errors on request params")
    ;

    private Integer code;
    private String message;

    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
