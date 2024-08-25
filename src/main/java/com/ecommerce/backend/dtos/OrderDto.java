package com.ecommerce.backend.dtos;

import java.util.Set;

public class OrderDto {
    private Long userID;
    private double totalAmount;
    private String status;
    private static Set<OrderDetailDto> orderDetails;

    public Long getUserID() {
        return userID;
    }

    public OrderDto setUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public OrderDto setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrderDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public static Set<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }

    public OrderDto setOrderDetails(Set<OrderDetailDto> orderDetails) {
        OrderDto.orderDetails = orderDetails;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "userID='" + userID + '\'' +
                "totalAmount='" + totalAmount + '\'' +
                ", status='" + status + '\'' +
                ", orderDetails='" + orderDetails + '\'' +
                '}';
    }

}