package com.praveen.ManyToMany_Bi.service;



import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.ManyToMany_Bi.dto.CategoryDTO;
import com.praveen.ManyToMany_Bi.entity.Category;
import com.praveen.ManyToMany_Bi.entity.Product;
import com.praveen.ManyToMany_Bi.mapper.CategoryMapper;
import com.praveen.ManyToMany_Bi.repository.CategoryRepository;
import com.praveen.ManyToMany_Bi.repository.ProductRepository;


@Service
public class CategoryService {

	

	/*
	 * @Transactional public Category createCategory(Category category) {
	 * 
	 * Set<Product> productsSet = category.getProducts();
	 * 
	 * // if(productsSet!=null) //
	 * productsSet.forEach(products->products.getCategories().add(category));
	 * 
	 * if (productsSet != null) for (Product product : productsSet) {
	 * product.getCategories().add(category); }
	 * 
	 * return categoryRepository.save(category); }
	 */
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    
    
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        // Fetch products based on provided IDs in categoryDTO
        Set<Product> products = Optional.ofNullable(categoryDTO.getProductIds())
                                         .orElse(Collections.emptySet())
                                         .stream()
                                         .map(id -> productRepository.findById(id)) // Using lambda expression instead of method reference
                                         .filter(optionalProduct -> optionalProduct.isPresent())
                                         .map(optionalProduct -> optionalProduct.get())
                                         .collect(Collectors.toSet());

        // Create the Category entity and set its products
        Category category = CategoryMapper.toEntity(categoryDTO, products);

        // Set the relationship on both sides explicitly
        for (Product product : products) {
            product.addCategory(category); // Adds the category to each product
        }

        // Save the category and the updated product relationships
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.toDto(savedCategory);
    }



    
    

	
}
