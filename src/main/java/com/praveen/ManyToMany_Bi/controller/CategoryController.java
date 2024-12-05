package com.praveen.ManyToMany_Bi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.ManyToMany_Bi.dto.CategoryDTO;
import com.praveen.ManyToMany_Bi.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/*
	 * @PostMapping("/create-category") public ResponseEntity<Category>
	 * createCategory(@RequestBody Category category){
	 * 
	 * Category categoryCreated =categoryService.createCategory(category);
	 * 
	 * return new ResponseEntity<Category>(categoryCreated, HttpStatus.CREATED);
	 * 
	 * }
	 * 
	 * @GetMapping("/get-category") public ResponseEntity<Set<CategoryDto>>
	 * getCategoryWithProducts(){ Set<CategoryDto> categoryWithProducts
	 * =categoryService.getCategoryWithProducts(); return new
	 * ResponseEntity<Set<CategoryDto>>(categoryWithProducts, HttpStatus.OK); }
	 */
	@PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }


}
