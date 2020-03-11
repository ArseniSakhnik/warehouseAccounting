package com.example.warehouseAccounting.repos;

import com.example.warehouseAccounting.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Long> {
}
