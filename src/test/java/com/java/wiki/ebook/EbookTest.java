package com.java.wiki.ebook;

import com.java.wiki.config.WikiApplication;
import com.java.wiki.domain.Ebook;
import com.java.wiki.service.EbookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WikiApplication.class)
public class EbookTest {

    @Resource
    private EbookService ebookService;

    @Test
    public void findEbooks(){
        List<Ebook> ebooks = ebookService.list();
        System.out.println(ebooks);
    }
}
