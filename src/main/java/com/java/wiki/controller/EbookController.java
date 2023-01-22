package com.java.wiki.controller;


import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.CommonResp;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.service.EbookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    private static final Logger LOG = LoggerFactory.getLogger(EbookController.class);

    @Resource
    private EbookService ebookService;

    @PostMapping("/list")
    public CommonResp list(@RequestBody EbookReq req){
        LOG.info("ebook request params:{}",req);
        PageResp<EbookResp> list = ebookService.list(req);
        return CommonResp.success(list);
    }

}
