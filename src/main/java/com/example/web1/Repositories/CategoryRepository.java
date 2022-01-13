package com.example.web1.Repositories;

import com.example.web1.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByIdIsNotOrderByCategoryName(long Id);

    @Query("select c from Category c order by c.categoryName")
    List<Category> findAllOrderByCategoryName();

    Category findCategoryByCategoryName(String categoryName);
}
