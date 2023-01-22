package com.java.wiki.controller;


import com.java.wiki.req.EbookQueryReq;
import com.java.wiki.req.EbookSaveReq;
import com.java.wiki.resp.CommonResp;
import com.java.wiki.resp.EbookQueryResp;
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
    public CommonResp list(@RequestBody EbookQueryReq req){
        LOG.info("ebook request params:{}",req);
        PageResp<EbookQueryResp> list = ebookService.list(req);
        return CommonResp.success(list);
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq ebookSaveReq){
        LOG.info("ebook save request params:{}",ebookSaveReq);
        ebookService.save(ebookSaveReq);
        return new CommonResp();
    }

}
