package com.example.web1.Services.ServiceImpl;

import com.example.web1.Entities.Category;
import com.example.web1.Repositories.CategoryRepository;
import com.example.web1.Services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategoriesExcept(Long id) {
        return categoryRepository.findAllByIdIsNotOrderByCategoryName(id);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.getById(id);
        categoryRepository.delete(category);
    }
}
