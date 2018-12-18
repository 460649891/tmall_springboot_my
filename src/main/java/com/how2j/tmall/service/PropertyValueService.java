package com.how2j.tmall.service;

import com.how2j.tmall.dao.PropertyDao;
import com.how2j.tmall.dao.PropertyValueDao;
import com.how2j.tmall.pojo.Product;
import com.how2j.tmall.pojo.Property;
import com.how2j.tmall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @title title
 * @date 2018/12/11
 * @description: TODO(用一句话描述该文件做什么)
 */
@Service
public class PropertyValueService {

    @Autowired
    PropertyDao propertyDao;

    @Autowired
    PropertyValueDao propertyValueDao;

    /**
     * 调用propertyValueService.init(product)，对propertyValues表数据进行初始化
     *
     * @param product 产品实体
     */
    public void init(Product product) {
        //通过product的category获取List<property>
        List<Property> properties = propertyDao.findByCategory(product.getCategory());
        //遍历List<property>
        for (Property property : properties) {
            //调用dao方法，通过product和property获取propertyValue，
            PropertyValue propertyValue = propertyValueDao.getByPropertyAndProduct(property, product);
            //如果propertyValues不存在,new propertyValue,并设置当前property,和product,调用dao层方法保存。
            if (propertyValue == null) {
                propertyValue = new PropertyValue();
                propertyValue.setProduct(product);
                propertyValue.setProperty(property);
                propertyValueDao.save(propertyValue);
            }
        }
    }

    public List<PropertyValue> list(Product product) {
        return propertyValueDao.findByProductOrderByIdDesc(product);
    }

    public void update(PropertyValue bean) {
        propertyValueDao.save(bean);
    }
}
