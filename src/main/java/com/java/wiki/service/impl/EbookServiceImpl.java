package com.java.wiki.service.impl;

import com.java.wiki.domain.Ebook;
import com.java.wiki.domain.EbookExample;
import com.java.wiki.mapper.EbookMapper;
import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.service.EbookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {

    @Resource
    private EbookMapper ebookMapper;


    @Override
    public List<EbookResp> list(EbookReq req) {
        List<Ebook> ebookList;
        if(StringUtils.isEmpty(req.getName())){
            ebookList = ebookMapper.selectByExample(null);
        }else {
            EbookExample ebookExample = new EbookExample();
            EbookExample.Criteria criteria = ebookExample.createCriteria();
            criteria.andNameLike("%"+ req.getName() + "%");
            ebookList = ebookMapper.selectByExample(ebookExample);
        }
        return getEbookRespList(ebookList);
    }




    //------------------------------------------------------------------------

    private List<EbookResp> getEbookRespList(List<Ebook> ebookList){
        List<EbookResp> ebookRespList = new ArrayList<>();
        for(Ebook ebook : ebookList){
            EbookResp ebookResp = new EbookResp();
            setEbookResp(ebook,ebookResp);
            ebookRespList.add(ebookResp);
        }
        return ebookRespList;
    }

    private void setEbookResp(Ebook source,EbookResp target){
        BeanUtils.copyProperties(source,target);
    }
}
