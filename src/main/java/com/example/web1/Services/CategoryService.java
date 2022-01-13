package com.example.web1.Services;

import com.example.web1.Entities.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategoriesExcept(Long id);

    void deleteCategory(Long id);
}
