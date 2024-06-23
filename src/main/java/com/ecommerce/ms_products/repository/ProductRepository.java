package com.ecommerce.ms_products.repository;

import com.ecommerce.ms_products.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) AND p.category.id = :categoryId")
    Page<Product> findByNameAndCategoryId(@Param("name") String name, @Param("categoryId") UUID categoryId, Pageable pageable);
}
