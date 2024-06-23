package com.ecommerce.ms_products.service;

import com.ecommerce.ms_products.dto.ProductDTO;
import com.ecommerce.ms_products.exceptions.ResourceNotFoundException;
import com.ecommerce.ms_products.mapper.ProductMapper;
import com.ecommerce.ms_products.model.Product;
import com.ecommerce.ms_products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(UUID id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(Product.class.getName(), id));
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDto(productRepository.save(product));
    }

    public ProductDTO updateProduct(UUID id, ProductDTO productDTO) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    Product product = productMapper.toEntity(productDTO);
                    product.setId(existingProduct.getId());
                    return productMapper.toDto(productRepository.save(product));
                })
                .orElseThrow(() -> new ResourceNotFoundException(Product.class.getName(), id));
    }

    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }


}
