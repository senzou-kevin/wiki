package com.java.wiki.controller;


import com.java.wiki.domain.TestObj;
import com.java.wiki.exception.WikiException;
import com.java.wiki.exception.code.WikiExceptionCode;
import com.java.wiki.resp.CommonResp;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public CommonResp hello(){
        return CommonResp.success("Hello World");
    }

    @PostMapping("/testException")
    public CommonResp testException(@RequestBody @Validated TestObj testObj){
        return CommonResp.success(testObj);
    }

    @GetMapping("/testWikiException")
    public CommonResp testWikiException() {
        boolean dataOperation = false;
        if (dataOperation) {
            return CommonResp.success("test wiki exception successfully");
        } else {
            throw new WikiException(WikiExceptionCode.WIKI_DB_OPERATION_FAIL, "db operation fail");
        }
    }
}
