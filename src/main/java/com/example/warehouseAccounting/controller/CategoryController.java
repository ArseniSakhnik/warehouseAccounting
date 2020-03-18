package com.example.warehouseAccounting.controller;

import com.example.warehouseAccounting.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping
    public String categoryList(Model model)
    {
        model.addAttribute("categoryList", categoryRepo.findAll());
        return "category";
    }

    @GetMapping("/addCategory")
    public String addCategory()
    {
        return "addCategory";
    }

}
