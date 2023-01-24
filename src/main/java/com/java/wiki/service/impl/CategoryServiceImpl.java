package com.java.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.wiki.domain.Category;
import com.java.wiki.domain.CategoryExample;
import com.java.wiki.mapper.CategoryMapper;
import com.java.wiki.req.CategoryQueryReq;
import com.java.wiki.req.CategorySaveReq;
import com.java.wiki.resp.CategoryQueryResp;
import com.java.wiki.resp.PageResp;
import com.java.wiki.service.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private SnowFlake snowFlake;


    @Override
    public PageResp<CategoryQueryResp> list(CategoryQueryReq req) {

        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);

        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        PageResp<CategoryQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(CopyUtil.copyList(categoryList, CategoryQueryResp.class));

        return pageResp;
    }

    @Override
    public void save(CategorySaveReq categorySaveReq) {
        Category category = CopyUtil.copy(categorySaveReq,Category.class);
        if(Objects.isNull(categorySaveReq.getId())){
            // id is null, so it is save operation
            long id = snowFlake.nextId();
            category.setId(id);
            categoryMapper.insert(category);
        }else {
            // id exists, so it is update operation
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    @Override
    public void delete(Long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryQueryResp> findAll() {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        return CopyUtil.copyList(categories, CategoryQueryResp.class);
    }


    //------------------------------------------------------------------------

    private List<CategoryQueryResp> getCategoryRespList(List<Category> categoryList){
        List<CategoryQueryResp> categoryQueryRespList = new ArrayList<>();
        for(Category category : categoryList){
            CategoryQueryResp categoryQueryResp = new CategoryQueryResp();
            setCategoryResp(category, categoryQueryResp);
            categoryQueryRespList.add(categoryQueryResp);
        }
        return categoryQueryRespList;
    }

    private void setCategoryResp(Category source, CategoryQueryResp target){
        BeanUtils.copyProperties(source,target);
    }
}
