package com.ecommerce.ms_products.mapper;

import com.ecommerce.ms_products.dto.CategoryDTO;
import com.ecommerce.ms_products.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO categoryDTO);
}
