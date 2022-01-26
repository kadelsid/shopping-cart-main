package com.technova.shopping_cart.TechNova.Cart.repository;

import com.technova.shopping_cart.TechNova.Cart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}