package com.ecommerce.backend.dtos;

public class OrderDetailDto {
    private int quantity;
    private double unitPrice;
    private double subtotal;
    private Long productID;

    public int getQuantity() {
        return quantity;
    }

    public OrderDetailDto setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public OrderDetailDto setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public OrderDetailDto setSubtotal(double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public Long getProductID() {
        return productID;
    }

    public OrderDetailDto setProductID(Long productID) {
        this.productID = productID;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" +
                "quantity='" + quantity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", subtotal='" + subtotal + '\'' +
                ", productID='" + productID + '\'' +
                '}';
    }

}
