package com.how2j.tmall.service;

import com.how2j.tmall.dao.CategoryDao;
import com.how2j.tmall.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @title title
 * @date 2018/11/30
 * @description: TODO(用一句话描述该文件做什么)
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;


    public List<Category> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return categoryDao.findAll(sort);
    }


}
