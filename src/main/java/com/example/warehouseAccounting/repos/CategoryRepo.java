package com.example.warehouseAccounting.repos;

import com.example.warehouseAccounting.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    Category findByCategoryName(String categoryName);
}
