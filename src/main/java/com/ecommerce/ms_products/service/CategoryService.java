package com.ecommerce.ms_products.service;

import com.ecommerce.ms_products.dto.CategoryDTO;
import com.ecommerce.ms_products.exceptions.ResourceNotFoundException;
import com.ecommerce.ms_products.mapper.CategoryMapper;
import com.ecommerce.ms_products.model.Category;
import com.ecommerce.ms_products.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories(String name, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categoryPage;
        if (name != null && !name.isEmpty()) {
            categoryPage = categoryRepository.findByNameContainingIgnoreCase(name, pageable);
        } else {
            categoryPage = categoryRepository.findAll(pageable);
        }
        return categoryPage.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategoryDTO getCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), id));
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    public CategoryDTO updateCategory(UUID id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    Category category = categoryMapper.toEntity(categoryDTO);
                    category.setId(existingCategory.getId());
                    return categoryMapper.toDto(categoryRepository.save(category));
                })
                .orElseThrow(() -> new ResourceNotFoundException(Category.class.getName(), id));
    }

    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

}
