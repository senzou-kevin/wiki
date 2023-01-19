package com.java.wiki.exception;

import com.java.wiki.commons.StatusCode;

public class WikiException extends RuntimeException{

    private int code;

    private String errorMsg;

    public WikiException(StatusCode statusCode, String errorMsg){
        super(errorMsg);
        this.code = statusCode.getCode();
        this.errorMsg = statusCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
