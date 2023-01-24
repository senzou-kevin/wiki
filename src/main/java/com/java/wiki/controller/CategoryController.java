package com.java.wiki.controller;


import com.java.wiki.req.CategoryQueryReq;
import com.java.wiki.req.CategorySaveReq;
import com.java.wiki.resp.CommonResp;
import com.java.wiki.resp.CategoryQueryResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private CategoryService categoryService;

    @PostMapping("/list")
    public CommonResp list(@RequestBody CategoryQueryReq req){
        LOG.info("category request params:{}",req);
        PageResp<CategoryQueryResp> list = categoryService.list(req);
        return CommonResp.success(list);
    }
    @GetMapping("/all")
    public CommonResp all(){
        List<CategoryQueryResp> list = categoryService.findAll();
        LOG.info("find all categorys:{}",list);
        return CommonResp.success(list);
    }
    @PostMapping("/save")
    public CommonResp save(@RequestBody CategorySaveReq categorySaveReq){
        LOG.info("category save request params:{}",categorySaveReq);
        categoryService.save(categorySaveReq);
        return new CommonResp();
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable("id") Long id){
        LOG.info("category delete request, id:{}",id);
        categoryService.delete(id);
        return new CommonResp();
    }

}
