package com.java.wiki.service;

import com.java.wiki.req.CategoryQueryReq;
import com.java.wiki.req.CategorySaveReq;
import com.java.wiki.resp.CategoryQueryResp;
import com.java.wiki.resp.PageResp;

import java.util.List;

public interface CategoryService {

    public PageResp<CategoryQueryResp> list(CategoryQueryReq req);

    public void save(CategorySaveReq categorySaveReq);

    public void delete(Long id);

    public List<CategoryQueryResp> findAll();

}
