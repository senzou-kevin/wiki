package com.java.wiki.service;

import com.java.wiki.domain.Ebook;
import com.java.wiki.req.EbookReq;
import com.java.wiki.resp.EbookResp;
import com.java.wiki.resp.PageResp;

import java.util.List;

public interface EbookService {

    public PageResp<EbookResp> list(EbookReq req);

}
