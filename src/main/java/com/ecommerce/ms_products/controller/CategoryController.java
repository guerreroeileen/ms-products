package com.ecommerce.ms_products.controller;


import com.ecommerce.ms_products.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

}
