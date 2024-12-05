package com.praveen.ManyToMany_Bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.ManyToMany_Bi.dto.ProductDTO;
import com.praveen.ManyToMany_Bi.entity.Product;
import com.praveen.ManyToMany_Bi.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	/*
	 * @Autowired private ProductService productService;
	 * 
	 * @PostMapping("/create-product") public ResponseEntity<Product>
	 * createProduct(@RequestBody Product product){
	 * 
	 * Product productCreated = productService.createProduct(product);
	 * 
	 * return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);
	 * 
	 * 
	 * }
	 */
	
	/*
	 * @Autowired private ProductRepository productRepository;
	 * 
	 * @Autowired private ProductMapper productMapper;
	 * 
	 * public ProductDTO createProduct(ProductDTO productDTO) { Product product =
	 * productMapper.convertToEntity(productDTO); product =
	 * productRepository.save(product); return productMapper.convertToDTO(product);
	 * }
	 * 
	 * public Set<ProductDTO> getAllProducts() { List<Product> products =
	 * productRepository.findAll(); return products.stream()
	 * .map(productMapper::convertToDTO) .collect(Collectors.toSet()); }
	 */
	@Autowired private ProductService productService;
	
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

}
