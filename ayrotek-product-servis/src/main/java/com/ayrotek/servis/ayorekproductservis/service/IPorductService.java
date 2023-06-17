package com.ayrotek.servis.ayorekproductservis.service;

import com.ayrotek.servis.ayorekproductservis.dto.ProductDTO;
import com.ayrotek.servis.ayorekproductservis.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPorductService {

    Product save(ProductDTO productDTO);
    List<Product> getAll();
    void deleteById(UUID id);
    void update(ProductDTO productDTO);

    Product findProductById(UUID id);
}
