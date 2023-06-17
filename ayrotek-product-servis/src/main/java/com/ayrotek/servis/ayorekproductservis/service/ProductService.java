package com.ayrotek.servis.ayorekproductservis.service;

import com.ayrotek.servis.ayorekproductservis.Utils.ProductUtils;
import com.ayrotek.servis.ayorekproductservis.dto.ProductDTO;
import com.ayrotek.servis.ayorekproductservis.model.Product;
import com.ayrotek.servis.ayorekproductservis.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IPorductService {
    private final ProductRepository productRepository;
    private final ProductUtils productUtils;

    @Override
    public Product save(ProductDTO productDTO) {
        var newProduct = productUtils.productToSave(productDTO);
        return this.productRepository.save(newProduct);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        if (productUtils.isCreator(id)) {
            this.productRepository.deleteById(id);
        } else {
            System.err.println("err");
        }

    }

    @Override
    public void update(ProductDTO productDTO) {
        Product newProduct = this.productUtils.productToUpdate(productDTO);
        if (productUtils.isCreator(newProduct.getId())) {
            this.productRepository.save(newProduct);
        } else {
            System.err.println("err");
        }
    }

    public Product findProductById(UUID id) {
        Product product = this.productRepository.findProductById(id);
        return product;
    }
}
