package com.ecommerce.ms_products.mapper;

import com.ecommerce.ms_products.dto.ProductDTO;
import com.ecommerce.ms_products.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category", target = "categoryDTO")
    ProductDTO toDto(Product product);
    @Mapping(source = "categoryDTO", target = "category")
    Product toEntity(ProductDTO productDTO);
}
