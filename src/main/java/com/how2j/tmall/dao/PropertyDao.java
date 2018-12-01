package com.how2j.tmall.dao;

import com.how2j.tmall.pojo.Category;
import com.how2j.tmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin
 * @title title
 * @date 2018/12/1
 * @description: TODO(jparepository提供基本的CURD和分页查询等操作方法)
 */
public interface PropertyDao extends JpaRepository<Property, Integer> {
    Page<Property> findByCategory(Category category, Pageable pageable);
}
