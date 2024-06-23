package com.ecommerce.ms_products.repository;

import com.ecommerce.ms_products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
