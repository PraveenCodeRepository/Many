package com.praveen.ManyToMany_Bi.mapper;

import com.praveen.ManyToMany_Bi.dto.ProductDTO;
import com.praveen.ManyToMany_Bi.entity.Category;
import com.praveen.ManyToMany_Bi.entity.Product;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDTO toDto(Product product) {
        Set<Long> categoryIds = product.getCategories()
                                        .stream()
                                        .map(category->category.getId())
                                        .collect(Collectors.toSet());
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), categoryIds);
    }

    public static Product toEntity(ProductDTO productDTO, Set<Category> categories) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategories(categories);
        return product;
    }
}

