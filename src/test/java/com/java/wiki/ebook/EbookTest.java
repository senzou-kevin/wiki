package com.java.wiki.ebook;

import com.java.wiki.config.WikiApplication;
import com.java.wiki.domain.Ebook;
import com.java.wiki.req.EbookReq;
import com.java.wiki.req.PageReq;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WikiApplication.class)
public class EbookTest {

    private static final Logger LOG = LoggerFactory.getLogger(EbookTest.class);

    @Resource
    private EbookService ebookService;

    @Test
    public void findEbooks(){
        EbookReq ebookReq = new EbookReq();
        ebookReq.setPage(1);
        ebookReq.setSize(3);
        PageResp<EbookResp> pageResp = ebookService.list(ebookReq);
        LOG.info("ebooks:{},size:{}",pageResp.getList(), pageResp.getList().size());

        ebookReq.setName("教程");
        pageResp = ebookService.list(ebookReq);
        LOG.info("ebooks:{},size:{}",pageResp.getList(),pageResp.getList().size());

        ebookReq.setName("Java");
        pageResp = ebookService.list(ebookReq);
        LOG.info("ebooks:{},size:{}",pageResp.getList(),pageResp.getList().size());
    }



}
