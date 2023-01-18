package com.java.wiki.resp;


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
        return  commonResp;
    }

    public static <T> CommonResp<T> fail(T data,String errorMessage){
        CommonResp<T> commonResp = new CommonResp<>();
        commonResp.setMessage(errorMessage);
        commonResp.setSuccess(false);
        commonResp.setContent(null);
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


}
