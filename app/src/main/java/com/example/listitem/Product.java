package com.example.listitem;


public class Product {
    int imgView;
    String name;
    int price;
    int productID;

    public Product(int productID, String name, int price, int imgView) {
        this.name = name;
        this.price = price;
        this.productID = productID;
        this.imgView = imgView;
    }
}
