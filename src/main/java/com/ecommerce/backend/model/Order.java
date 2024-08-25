package com.ecommerce.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @Column(nullable = false)
    private double totalAmount;

    @Column(nullable = false)
    private String status;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    // Getters y Setters

    public Long getID() {
        return orderID;
    }

    public Order setID(Long id) {
        this.orderID = id;
        return this;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Order setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public Order setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        if (orderDetail != null) {
            orderDetails.add(orderDetail);
            orderDetail.setOrder(this); // Establece la relación bidireccional
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
