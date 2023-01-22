package com.java.wiki.service;

import com.java.wiki.req.EbookQueryReq;
import com.java.wiki.req.EbookSaveReq;
import com.java.wiki.resp.EbookQueryResp;
import com.java.wiki.resp.PageResp;

public interface EbookService {

    public PageResp<EbookQueryResp> list(EbookQueryReq req);

    public void save(EbookSaveReq ebookSaveReq);

    public void delete(Long id);

}
