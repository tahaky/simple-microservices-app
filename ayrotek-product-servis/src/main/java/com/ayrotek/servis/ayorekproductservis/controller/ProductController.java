package com.ayrotek.servis.ayorekproductservis.controller;


import com.ayrotek.servis.ayorekproductservis.dto.ProductDTO;
import com.ayrotek.servis.ayorekproductservis.model.Product;
import com.ayrotek.servis.ayorekproductservis.repo.PersonRepository;
import com.ayrotek.servis.ayorekproductservis.repo.ProductRepository;
import com.ayrotek.servis.ayorekproductservis.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final PersonRepository personRepository;
    private final ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> getAll() {
        return this.productService.getAll();
    }


    @PostMapping("/")
    public Product save(@RequestBody ProductDTO productDTO) {
        return this.productService.save(productDTO);
    }

    @PutMapping("/")
    public void update(@RequestBody ProductDTO productDTO) {
        this.productService.update(productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        this.productService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public Product getById(@PathVariable(name = "id") UUID id) {
        return this.productService.findProductById(id);
    }

}
