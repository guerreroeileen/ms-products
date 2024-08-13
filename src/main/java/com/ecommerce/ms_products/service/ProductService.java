package com.ecommerce.ms_products.service;

import com.ecommerce.ms_products.dto.ProductDTO;
import com.ecommerce.ms_products.exceptions.ResourceNotFoundException;
import com.ecommerce.ms_products.mapper.ProductMapper;
import com.ecommerce.ms_products.model.Product;
import com.ecommerce.ms_products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.ecommerce.ms_products.constants.CacheConstants.GET_ALL_PRODUCTS;
import static com.ecommerce.ms_products.constants.CacheConstants.GET_PRODUCT_BY_ID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Cacheable(GET_ALL_PRODUCTS)
    public Page<ProductDTO> getAllProducts(Integer page, Integer size, String productName, UUID categoryId, String sortDirection) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Sort sort = Sort.by(direction, "price");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Product> productsPage = productRepository.findByNameAndCategoryId(productName, categoryId, pageable);

        return productsPage.map(productMapper::toDto);
    }

    @Cacheable(GET_PRODUCT_BY_ID)
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
