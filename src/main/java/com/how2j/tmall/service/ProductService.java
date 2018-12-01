package com.how2j.tmall.service;

import com.how2j.tmall.dao.CategoryDao;
import com.how2j.tmall.dao.ProductDao;
import com.how2j.tmall.pojo.Category;
import com.how2j.tmall.pojo.Product;
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
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;


    public List<Product> list() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return productDao.findAll(sort);
    }

    public Page4Navigator<Product> list(int cid, int start, int size, int navigatePages) {
        Category category = categoryDao.findOne(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Product> pageFromJPA = productDao.findByCategory(category, pageable);
        return new Page4Navigator<>(pageFromJPA, navigatePages);
    }


    public void add(Product bean) {
        productDao.save(bean);
    }

    public void delete(int id) {
        productDao.delete(id);
    }

    public Product get(int id) {
        return productDao.getOne(id);
    }

    public void update(Product bean) {
        productDao.save(bean);
    }
}
