package com.java.wiki.controller;


import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.CommonResp;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;

    @PostMapping("/list")
    public CommonResp list(EbookReq req){
        PageResp<EbookResp> list = ebookService.list(req);
        return CommonResp.success(list);
    }

}
