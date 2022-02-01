package com.Cart.service;

import com.Cart.dto.CategoryRequest;
import com.Cart.model.Category;
import com.Cart.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryRequest categoryRequest) {
        Category newCategory = new Category();
       // newCategory.setEmail(categoryRequest.getEmail());

        newCategory.setCategoryName(categoryRequest.getCategoryName());
        newCategory.setCreatedBy(categoryRequest.getCreatedBy());
        return categoryRepository.save(newCategory);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
