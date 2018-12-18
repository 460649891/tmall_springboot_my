package com.how2j.tmall.web;

import com.how2j.tmall.pojo.Product;
import com.how2j.tmall.pojo.PropertyValue;
import com.how2j.tmall.service.ProductService;
import com.how2j.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Contended;
import sun.misc.Request;

import java.util.List;

/**
 * @author admin
 * @title title
 * @date 2018/12/11
 * @description: TODO(用一句话描述该文件做什么)
 */
@RestController
public class PropertyValueController {


    @Autowired
    private PropertyValueService propertyValueService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/products/{pid}/propertyValues")
    public List<PropertyValue> list(@PathVariable("pid") int pid) {
        Product product = productService.get(pid);
        propertyValueService.init(product);
        List<PropertyValue> beans = propertyValueService.list(product);
        return beans;
    }

    @PutMapping("/propertyValues")
    public Object update(@RequestBody PropertyValue bean) throws Exception {
        propertyValueService.update(bean);
        return bean;
    }


}
