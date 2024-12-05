package com.praveen.ManyToMany_Bi.dto;

import java.util.HashSet;
import java.util.Set;

public class CategoryDTO {
	
    private Long id;
    private String name;
    private Set<Long> productIds = new HashSet<>(); // Only IDs to avoid circular dependency

    public CategoryDTO() {}

    public CategoryDTO(Long id, String name, Set<Long> productIds) {
        this.id = id;
        this.name = name;
        this.productIds = productIds;
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

    public Set<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Long> productIds) {
        this.productIds = productIds;
    }
}
