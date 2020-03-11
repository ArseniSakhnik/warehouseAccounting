package com.example.warehouseAccounting.controller;

import com.example.warehouseAccounting.domain.Category;
import com.example.warehouseAccounting.domain.Product;
import com.example.warehouseAccounting.repos.CategoryRepo;
import com.example.warehouseAccounting.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/main")
    public String main(Map<String, Object> map)
    {
        return "mains";
    }

}
