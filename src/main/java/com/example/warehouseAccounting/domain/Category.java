package com.example.warehouseAccounting.domain;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String categoryName;
    private String categoryDescription;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="product_id")
    private Set<Product> products = new LinkedHashSet<>();

    public Category() {
    }

    public Category(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, String categoryDescription)
    {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        product.setCategory(this);
        this.products.add(product);
    }
}
