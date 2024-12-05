package com.praveen.ManyToMany_Bi.mapper;


import com.praveen.ManyToMany_Bi.dto.CategoryDTO;
import com.praveen.ManyToMany_Bi.entity.Category;
import com.praveen.ManyToMany_Bi.entity.Product;
import java.util.Set;
import java.util.stream.Collectors;

public class CategoryMapper {

	public static CategoryDTO toDto(Category category) {
        Set<Long> productIds = category.getProducts()
                                        .stream()
                                        .map(product -> product.getId()) // Using lambda expression instead of method reference
                                        .collect(Collectors.toSet());
        return new CategoryDTO(category.getId(), category.getName(), productIds);
    }


    public static Category toEntity(CategoryDTO categoryDTO, Set<Product> products) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setProducts(products);
        return category;
    }
}

