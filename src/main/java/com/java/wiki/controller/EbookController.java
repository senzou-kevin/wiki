package com.java.wiki.controller;


import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.CommonResp;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public CommonResp<List<EbookResp>> list(EbookReq req){
        List<EbookResp> ebookResp= ebookService.list(req);
        return CommonResp.success(ebookResp);
    }

}
