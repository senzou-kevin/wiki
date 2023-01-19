package com.java.wiki.resp;


import com.java.wiki.commons.ResultCode;

/**
 * commonResponse to front-end
 * @param <T>
 */
public class CommonResp<T> {

    /**
     * true: success, false:fail
     */
    private boolean success = true;

    /**
      the code that represents if the request is successful or not
     */
    private int statusCode;

    /**
     * successful or fail message to front-end
     */
    private String message;

    /**
     * data that front-end need
     */
    private T content;

    public static <T> CommonResp<T> success(T data){
        CommonResp<T> commonResp = new CommonResp<>();
        commonResp.setMessage("success");
        commonResp.setSuccess(true);
        commonResp.setContent(data);
        commonResp.setStatusCode(ResultCode.SUCCESS.getCode());
        return  commonResp;
    }

    public static <T> CommonResp<T> fail(String errorMessage,int errorCode){
        CommonResp<T> commonResp = new CommonResp<>();
        commonResp.setMessage(errorMessage);
        commonResp.setSuccess(false);
        commonResp.setContent(null);
        commonResp.setStatusCode(errorCode);
        return commonResp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
