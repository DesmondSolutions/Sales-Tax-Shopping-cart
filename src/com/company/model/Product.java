
package com.company.model;

//All the items in the shopping cart will be created from this model
public class Product {
    private int quantity;
    private String productName;
    private double price;

    public Product(int quantity, String productName, double price) {
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public double totalPrice(double quantity){
        return price * quantity;
    }

    @Override
    public String toString() {
        return  quantity + " " + productName + ": " + price;
    }
}
