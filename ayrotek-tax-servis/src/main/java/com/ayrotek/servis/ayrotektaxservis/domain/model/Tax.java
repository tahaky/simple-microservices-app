package com.ayrotek.servis.ayrotektaxservis.domain.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document("tax")
public class Tax {
    private String productId;
    private double productPrice;
    private double taxQuantitative;

    public Tax(String productId, double taxQuantitative,double productPrice) {
        this.productPrice=productPrice;
        this.productId = productId;
        this.taxQuantitative = taxQuantitative;
    }


}
