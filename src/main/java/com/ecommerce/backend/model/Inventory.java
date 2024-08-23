package com.ecommerce.backend.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryID;

    @Column(nullable = false)
    private int quantityInStock;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRestockedDate;

    // Relaciones
    @OneToOne
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    // Getters y Setters
}
