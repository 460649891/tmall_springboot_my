package com.how2j.tmall.dao;

import com.how2j.tmall.pojo.Product;
import com.how2j.tmall.pojo.Property;
import com.how2j.tmall.pojo.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author admin
 * @title title
 * @date 2018/12/11
 * @description: TODO(jparepository提供基本的CURD和分页查询等操作方法)
 */
public interface PropertyValueDao extends JpaRepository<PropertyValue, Integer> {
    PropertyValue getByPropertyAndProduct(Property property, Product product);

    List<PropertyValue> findByProductOrderByIdDesc(Product product);
}
