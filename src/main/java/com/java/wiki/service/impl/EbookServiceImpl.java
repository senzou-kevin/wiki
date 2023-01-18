package com.java.wiki.service.impl;

import com.java.wiki.domain.Ebook;
import com.java.wiki.mapper.EbookMapper;
import com.java.wiki.service.EbookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {

    @Resource
    private EbookMapper ebookMapper;


    @Override
    public List<Ebook> list() {
        return  ebookMapper.selectByExample(null);
    }
}
