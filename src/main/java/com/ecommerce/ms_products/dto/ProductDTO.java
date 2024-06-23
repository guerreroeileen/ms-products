package com.ecommerce.ms_products.dto;

import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Long categoryId;
}
