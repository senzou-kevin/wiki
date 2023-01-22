package com.java.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.wiki.domain.Ebook;
import com.java.wiki.domain.EbookExample;
import com.java.wiki.mapper.EbookMapper;
import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.service.EbookService;
import com.java.wiki.util.CopyUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookServiceImpl implements EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookServiceImpl.class);

    @Resource
    private EbookMapper ebookMapper;


    @Override
    public PageResp<EbookResp> list(EbookReq req) {
        List<Ebook> ebookList;
        if(StringUtils.isEmpty(req.getName())){
            //pageHelper只对下面遇到第一个sql有用。pageNum从1开始。
            PageHelper.startPage(req.getPage(),req.getSize());
            ebookList = ebookMapper.selectByExample(null);
        }else {
            EbookExample ebookExample = new EbookExample();
            EbookExample.Criteria criteria = ebookExample.createCriteria();
            criteria.andNameLike("%"+ req.getName() + "%");
            //pageHelper只对下面遇到第一个sql有用。pageNum从1开始。
            PageHelper.startPage(1,3);
            ebookList = ebookMapper.selectByExample(ebookExample);
        }
        LOG.info("ebookList:{}",ebookList);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);

        PageResp<EbookResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(CopyUtil.copyList(ebookList,EbookResp.class));

        return pageResp;
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
