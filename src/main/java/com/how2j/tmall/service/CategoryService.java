package com.how2j.tmall.service;

import com.how2j.tmall.dao.CategoryDao;
import com.how2j.tmall.pojo.Category;
import com.how2j.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Page4Navigator<Category> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page pageFromJPA = categoryDao.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }


    public void add(Category bean) {
        categoryDao.save(bean);
    }

    public void delete(int id) {
        categoryDao.delete(id);
    }

    public Category get(int id) {
        return categoryDao.getOne(id);
    }

    public void update(Category bean) {
         categoryDao.save(bean);
    }
}
