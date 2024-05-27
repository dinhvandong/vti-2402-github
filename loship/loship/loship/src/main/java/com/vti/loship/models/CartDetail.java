package com.vti.loship.models;

import org.springframework.data.annotation.Transient;

public class CartDetail {
    private  Long id;

    @Transient
    public static final String SEQUENCE_NAME = "cart_detail_sequence";
    private Long productID;
    private  String productName;
    private  String categoryName;
    private double price;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
