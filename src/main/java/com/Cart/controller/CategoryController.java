package com.Cart.controller;

import com.Cart.dto.CategoryRequest;
import com.Cart.model.Category;
import com.Cart.service.CategoryService;
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
