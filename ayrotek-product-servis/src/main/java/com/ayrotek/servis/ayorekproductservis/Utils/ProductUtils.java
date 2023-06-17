package com.ayrotek.servis.ayorekproductservis.Utils;

import com.ayrotek.servis.ayorekproductservis.dto.ProductDTO;
import com.ayrotek.servis.ayorekproductservis.model.Person;
import com.ayrotek.servis.ayorekproductservis.model.Product;
import com.ayrotek.servis.ayorekproductservis.repo.PersonRepository;
import com.ayrotek.servis.ayorekproductservis.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductUtils {
    private final PersonRepository personRepository;
    private final ProductRepository productRepository;
    private final WebClient webClient;

    public boolean isCreator(UUID id) {
        Optional<Person> person = personRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        Product product = productRepository.getById(id);
        if (product.getCreatedBy().equals(person.get().getId())) {
            return true;
        } else {
            return false;
        }
    }

    public Product productToUpdate(ProductDTO productDTO) {
        Product newProduct = productRepository.getById(productDTO.getId());
        newProduct.setProductName(productDTO.getProductName());
        newProduct.setPrice(productDTO.getPrice());
        newProduct.setTax(calculateTax(productDTO));
        return newProduct;
    }

    public Product productToSave(ProductDTO productDTO) {
        double tax = calculateTax(productDTO);
        Product newProduct = new Product(
                productDTO.getProductName(),
                productDTO.getPrice(),
                tax
        );
        return newProduct;
    }


    public double calculateTax(ProductDTO productDTO) {
        System.err.println("geldiiiii");
        double tax = webClient.get()
                .uri("http://localhost:8081/api/v1/tax/" + productDTO.getPrice())
                .retrieve()
                .bodyToMono(double.class)
                .block();
        return tax;

    }

}
