package com.how2j.tmall.dao;

import com.how2j.tmall.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author admin
 * @title title
 * @date 2018/11/30
 * @description: TODO(jparepository提供基本的CURD和分页查询等操作方法)
 */
public interface CategoryDao extends JpaRepository<Category, Integer> {



}
