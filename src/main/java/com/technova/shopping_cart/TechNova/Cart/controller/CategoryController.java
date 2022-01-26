package com.technova.shopping_cart.TechNova.Cart.controller;

import com.technova.shopping_cart.TechNova.Cart.dto.CategoryRequest;
import com.technova.shopping_cart.TechNova.Cart.model.Category;
import com.technova.shopping_cart.TechNova.Cart.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/categories")
    public Category createCategory(@RequestBody CategoryRequest categoryRequest) {
        Category savedCategory = categoryService.createCategory(categoryRequest);

        return savedCategory;
    }
    @GetMapping("/categories")
    public List<Category> getCategory(){
        return categoryService.getAllCategories();
    }


}
