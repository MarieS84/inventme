package com.example.invent;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="PRODUCTNAME")
    private String productName;

    @Column(name="EXPIRYDATE")
    private String expiryDate;

    @Column(name="PRODUCTCATEGORY")
    private String productCategory;

    public Product() {
    }

    public Product(Long id, String productName, String expiryDate, String productCategory) {
        this.id = id;
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
