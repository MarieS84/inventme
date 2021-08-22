package com.example.invent;

import javax.persistence.Entity;

@Entity
public class Product {
    private String productId;
    private String productName;
    private String expiryDate;
    private String productCategory;

    public Product(String productId, String productName, String expiryDate, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.expiryDate = expiryDate;
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
