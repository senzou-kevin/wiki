package com.java.wiki.exception.code;

import com.java.wiki.commons.StatusCode;

public enum WikiExceptionCode implements StatusCode {

    WIKI_DB_OPERATION_FAIL(2000,"database operation failed")

    ;

    private int code;
    private String message;

    WikiExceptionCode(int code,String message){
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
