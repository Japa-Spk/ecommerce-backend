package com.ecommerce.backend.model;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(nullable = false)
    private String productName;

    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false, unique = true)
    private String SKU;

    @Column(nullable = false)
    private Boolean active = false;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    // Relaciones
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;

    // Getters y Setters
}
