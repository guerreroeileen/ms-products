package com.ecommerce.ms_products.mapper;

import com.ecommerce.ms_products.dto.ProductDTO;
import com.ecommerce.ms_products.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDto(Product product);
    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(ProductDTO productDTO);
}
