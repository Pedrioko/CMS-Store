package com.pedrioko.github.cmsapi.repositories;

import com.pedrioko.github.cmsapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
