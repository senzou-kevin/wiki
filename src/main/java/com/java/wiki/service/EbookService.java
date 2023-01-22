package com.java.wiki.service;

import com.java.wiki.req.EbookQueryReq;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.resp.PageResp;

public interface EbookService {

    public PageResp<EbookResp> list(EbookQueryReq req);

}
