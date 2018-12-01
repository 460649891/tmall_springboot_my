package com.how2j.tmall.dao;

import com.how2j.tmall.pojo.Category;
import com.how2j.tmall.pojo.Product;
import com.how2j.tmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin
 * @title title
 * @date 2018/12/1
 * @description: TODO(用一句话描述该文件做什么)
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
    Page<Product> findByCategory(Category category, Pageable pageable);
}
