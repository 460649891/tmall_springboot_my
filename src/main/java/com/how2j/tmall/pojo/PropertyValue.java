package com.how2j.tmall.pojo;

import javax.persistence.*;

/**
 * @author admin
 * @title title
 * @date 2018/12/11
 * @description: TODO(属性值实体)
 */
@Entity
@Table(name = "propertyValue")
public class PropertyValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "ptid")
    private Property property;


    @Column(name = "value")
    private String value;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
