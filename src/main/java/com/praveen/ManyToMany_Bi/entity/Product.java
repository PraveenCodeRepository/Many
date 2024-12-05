package com.praveen.ManyToMany_Bi.entity;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Product { // owning side
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productId")
    private Long id;
    
    @Column(name="productName")
    private String name;
    
    @Column(name="productPrice")
    private double price;
    
    @JsonBackReference
    @ManyToMany
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name="product_id"),
        inverseJoinColumns = @JoinColumn(name="category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public Product() {}

    public Product(Long id, String name, double price, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    
    // Helper method to manage bidirectional relationship
    public void addCategory(Category category) {
        this.categories.add(category);
        category.getProducts().add(this);
    }
    
    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.getProducts().remove(this);
    }
}
