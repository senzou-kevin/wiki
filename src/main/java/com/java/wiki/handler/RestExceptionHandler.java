package com.java.wiki.handler;

import com.java.wiki.commons.ResultCode;
import com.java.wiki.exception.WikiException;
import com.java.wiki.resp.CommonResp;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * catch and return if the validation check has errors.
     * @return
     */
    @ExceptionHandler({BindException.class})
    public CommonResp methodArgumentExceptionHandler(){
        return CommonResp.fail(ResultCode.FAIL.getMessage(), ResultCode.FAIL.getCode());
    }

    /**
     *  catch and return if the wiki application occurs exceptions.
     * @param e wiki Exception
     * @return
     */
    @ExceptionHandler({WikiException.class})
    public CommonResp wikiExceptionHandler(WikiException e){
        return CommonResp.fail(e.getMessage(),e.getCode());
    }
}
