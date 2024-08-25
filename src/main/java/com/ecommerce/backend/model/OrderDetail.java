package com.ecommerce.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailID;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double unitPrice;

    @Column(nullable = false)
    private double subtotal;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "orderID")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    // Getters y Setters
    public int getQuantity() {
        return quantity;
    }

    public OrderDetail setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public OrderDetail setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public OrderDetail setSubtotal(double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderDetail setOrderId(Order order) {
        this.order = order;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public OrderDetail setProduct(Product product) {
        this.product = product;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "quantity='" + quantity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", subtotal='" + subtotal + '\'' +
                ", productID='" + product.getProductID() + '\'' +
                '}';
    }
}
