package com.java.wiki.ebook;

import com.java.wiki.config.WikiApplication;
import com.java.wiki.req.EbookQueryReq;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.service.EbookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WikiApplication.class)
public class EbookTest {

    private static final Logger LOG = LoggerFactory.getLogger(EbookTest.class);

    @Resource
    private EbookService ebookService;

    @Test
    public void findEbooks(){
        EbookQueryReq ebookQueryReq = new EbookQueryReq();
        ebookQueryReq.setPage(1);
        ebookQueryReq.setSize(3);
        PageResp<EbookResp> pageResp = ebookService.list(ebookQueryReq);
        LOG.info("ebooks:{},size:{}",pageResp.getList(), pageResp.getList().size());

        ebookQueryReq.setName("教程");
        pageResp = ebookService.list(ebookQueryReq);
        LOG.info("ebooks:{},size:{}",pageResp.getList(),pageResp.getList().size());

        ebookQueryReq.setName("Java");
        pageResp = ebookService.list(ebookQueryReq);
        LOG.info("ebooks:{},size:{}",pageResp.getList(),pageResp.getList().size());
    }



}
