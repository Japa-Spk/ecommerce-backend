package com.ecommerce.backend.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceHistoryID;

    @Column(nullable = false)
    private double oldPrice;

    @Column(nullable = false)
    private double newPrice;

    @Temporal(TemporalType.TIMESTAMP)
    private Date changeDate;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    private Product product;

    // Getters y Setters
}
