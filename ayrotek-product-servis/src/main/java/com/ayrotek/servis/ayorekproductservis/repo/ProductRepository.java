package com.ayrotek.servis.ayorekproductservis.repo;

import com.ayrotek.servis.ayorekproductservis.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product save(Product product);

    List<Product> findAll();

    void deleteById(UUID id);
    Product findProductById(UUID id);


}
