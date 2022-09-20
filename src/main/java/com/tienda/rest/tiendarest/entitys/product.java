package com.tienda.rest.tiendarest.entitys;

import javax.persistence.*;

@Entity
@Table(name = "products",uniqueConstraints = {@UniqueConstraint(columnNames = {"code"})})
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code",nullable = false,length = 8)
    private String code;

    @Column(name="productName",nullable = false,length = 20)
    private String name;

    @Column(name="productDescription",nullable = false)
    private String description;

    @Column(name="productPrice",nullable = false)
    private double price;

    @Column(name="productCategory",nullable = false)
    private String category;

    @Column(name="productStock",nullable = false)
    private int  stock;

    public product() {
        super();
    }

    public product(String name, String description, double price, String category, int stock,String code) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int  stock) {
        this.stock = stock;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
