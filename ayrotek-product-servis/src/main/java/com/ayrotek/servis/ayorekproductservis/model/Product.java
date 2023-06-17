package com.ayrotek.servis.ayorekproductservis.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseModel {
    @Column(name = "product_name")
    private String productName;
    private double price;
    private double tax;

    public Product(UUID id, String productName, double price, double tax) {
        super(id);
        this.productName = productName;
        this.price = price;
        this.tax = tax;
    }

}
