package com.how2j.tmall.service;

import com.how2j.tmall.dao.CategoryDao;
import com.how2j.tmall.dao.PropertyDao;
import com.how2j.tmall.pojo.Category;
import com.how2j.tmall.pojo.Property;
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
 * @date 2018/12/1
 * @description: TODO(用一句话描述该文件做什么)
 */
@Service
public class PropertyService {
    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private CategoryDao categoryDao;


    public List<Property> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return propertyDao.findAll(sort);
    }

    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryDao.findOne(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Property> pageFromJPA = propertyDao.findByCategory(category, pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }


    public void add(Property bean) {
        propertyDao.save(bean);
    }

    public void delete(int id) {
        propertyDao.delete(id);
    }

    public Property get(int id) {
        return propertyDao.getOne(id);
    }

    public void update(Property bean) {
        propertyDao.save(bean);
    }

}
