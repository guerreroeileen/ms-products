package com.ecommerce.ms_products.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryDTO {
    private UUID id;
    private String name;
}
