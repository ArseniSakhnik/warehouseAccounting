package com.example.warehouseAccounting.controller;

import com.example.warehouseAccounting.domain.Category;
import com.example.warehouseAccounting.domain.Product;
import com.example.warehouseAccounting.domain.User;
import com.example.warehouseAccounting.repos.CategoryRepo;
import com.example.warehouseAccounting.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String mainpage(Model model, User user)
    {
        Iterable<Product> products = productRepo.findAll();
        if (products != null)
            model.addAttribute("products", products);

        if (user == null)
            return "mainpage";
        else
            return "login";
    }

    @GetMapping("/mainpage")
    public String mainpage(Model model)
    {
        Iterable<Product> products = productRepo.findAll();
        if (products != null)
            model.addAttribute("products", products);

        return "mainpage";
    }

    @PostMapping("/mainpage")
    public String add(
            @RequestParam String categoryName,
            @RequestParam String productName,
            @RequestParam String productDescription,
            @RequestParam Float price,
            @RequestParam Integer quantity,
            @RequestParam("file")MultipartFile file,
            Model model) throws IOException {

            Category category = categoryRepo.findByCategoryName(categoryName);
            if (category == null)
                category = new Category(categoryName);

            Product product = new Product(productName.toLowerCase(), productDescription, price, quantity);
            product.setCategory(category);

            if (file != null) {
                File uploadDir = new File(uploadPath);

                if (!uploadDir.exists())
                {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                product.setImageName(resultFileName);
            }

            categoryRepo.save(category);
            productRepo.save(product);

            Iterable<Product> products = productRepo.findAll();
            model.addAttribute("products", products);

            return "mainpage";
    }

}
