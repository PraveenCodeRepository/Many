package com.praveen.ManyToMany_Bi.service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.ManyToMany_Bi.dto.ProductDTO;
import com.praveen.ManyToMany_Bi.entity.Category;
import com.praveen.ManyToMany_Bi.entity.Product;
import com.praveen.ManyToMany_Bi.mapper.ProductMapper;
import com.praveen.ManyToMany_Bi.repository.CategoryRepository;
import com.praveen.ManyToMany_Bi.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	/*
	 * @Autowired private ProductRepository productRepository;
	 * 
	 * @Transactional public Product createProduct(Product product) {
	 * 
	 * Set<Category> categorySet = product.getCategories();
	 * 
	 * if(categorySet!=null)
	 * categorySet.forEach(category->category.addProduct(product));
	 * 
	 * return productRepository.save(product);
	 * 
	 * }
	 */	
	
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    
    
    public ProductDTO createProduct(ProductDTO productDTO) {
        // Fetch categories based on provided IDs in productDTO
        Set<Category> categories = Optional.ofNullable(productDTO.getCategoryIds())
                                            .orElse(Collections.emptySet())
                                            .stream()
                                            .map(categoryRepository::findById)
                                            .filter(Optional::isPresent)
                                            .map(Optional::get)
                                            .collect(Collectors.toSet());

        // Create the Product entity and set its categories
        Product product = ProductMapper.toEntity(productDTO, categories);

        // Set the relationship on both sides explicitly
        for (Category category : categories) {
            category.addProduct(product); // adds the product to each category
        }

        // Save the product and the updated category relationships
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toDto(savedProduct);
    }



}
