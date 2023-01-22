package com.java.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.wiki.domain.Ebook;
import com.java.wiki.domain.EbookExample;
import com.java.wiki.mapper.EbookMapper;
import com.java.wiki.req.EbookQueryReq;
import com.java.wiki.req.EbookSaveReq;
import com.java.wiki.resp.EbookQueryResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.service.EbookService;
import com.java.wiki.util.CopyUtil;
import com.java.wiki.util.SnowFlake;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EbookServiceImpl implements EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookServiceImpl.class);

    @Resource
    private EbookMapper ebookMapper;

    @Resource
    private SnowFlake snowFlake;


    @Override
    public PageResp<EbookQueryResp> list(EbookQueryReq req) {
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

        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(CopyUtil.copyList(ebookList, EbookQueryResp.class));

        return pageResp;
    }

    @Override
    public void save(EbookSaveReq ebookSaveReq) {
        Ebook ebook = CopyUtil.copy(ebookSaveReq,Ebook.class);
        if(Objects.isNull(ebookSaveReq.getId())){
            // id is null, so it is save operation
            long id = snowFlake.nextId();
            ebook.setId(id);
            ebookMapper.insert(ebook);
        }else {
            // id exists, so it is update operation
            ebookMapper.updateByPrimaryKey(ebook);
        }
    }


    //------------------------------------------------------------------------

    private List<EbookQueryResp> getEbookRespList(List<Ebook> ebookList){
        List<EbookQueryResp> ebookQueryRespList = new ArrayList<>();
        for(Ebook ebook : ebookList){
            EbookQueryResp ebookQueryResp = new EbookQueryResp();
            setEbookResp(ebook, ebookQueryResp);
            ebookQueryRespList.add(ebookQueryResp);
        }
        return ebookQueryRespList;
    }

    private void setEbookResp(Ebook source, EbookQueryResp target){
        BeanUtils.copyProperties(source,target);
    }
}
