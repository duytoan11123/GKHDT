package com.example.demo.controller;

import com.example.demo.dto.ProductCreateDTO;
import java.util.ArrayList;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductCreateDTO dto) {
        try {
            Product newProduct = productService.createProduct(dto);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Nên log lỗi chi tiết ở đây
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public List<Product> getAllProduct(){
    	List<Product> allProduct = new ArrayList<>();
    	productService.getAllProduct();
    	return allProduct;
    }
    
}