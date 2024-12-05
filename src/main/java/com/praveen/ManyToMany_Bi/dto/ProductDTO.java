package com.praveen.ManyToMany_Bi.dto;

import java.util.Set;

public class ProductDTO {
	
    private Long id;
    private String name;
    private double price;
    private Set<Long> categoryIds; // Only IDs to avoid circular dependency

    public ProductDTO() {}

    public ProductDTO(Long id, String name, double price, Set<Long> categoryIds) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryIds = categoryIds;
    }

    // Getters and Setters
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

    public Set<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
