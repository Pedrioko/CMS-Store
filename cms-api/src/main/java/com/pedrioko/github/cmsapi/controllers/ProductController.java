package com.pedrioko.github.cmsapi.controllers;

import com.pedrioko.github.cmsapi.domain.Product;
import com.pedrioko.github.cmsapi.exceptions.ProductNotFoundException;
import com.pedrioko.github.cmsapi.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> all() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    public Product one(@PathVariable Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    public Product updateEmployee(@RequestBody Product product, @PathVariable Long id) {

        return productRepository.findById(id)
                .map(product_old -> {
                    product_old.setName(product.getName());
                    product_old.setCost(product.getCost());
                    product_old.setPreview(product.getPreview());
                    product_old.setQuantity(product.getQuantity());
                    product_old.setSaleprice(product.getSaleprice());
                    product_old.setTagList(product.getTagList());
                    product_old.setCategoryList(product.getCategoryList());
                    return productRepository.save(product_old);
                })
                .orElseGet(() -> {
                    product.setId(id);
                    return productRepository.save(product);
                });
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
