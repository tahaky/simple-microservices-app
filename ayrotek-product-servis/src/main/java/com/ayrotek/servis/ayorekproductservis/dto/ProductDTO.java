package com.ayrotek.servis.ayorekproductservis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private UUID id;
    private String productName;
    private double price;
    private double tax;

}
