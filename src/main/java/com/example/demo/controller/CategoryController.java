package com.example.demo.controller;

import com.example.demo.dto.CategoryCreateDTO;
import com.example.demo.model.Language;
import com.example.demo.model.ProductCategory;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    @Autowired private CategoryService categoryService;

    // Endpoint tạo Danh mục kèm bản dịch
    @PostMapping
    public ResponseEntity<ProductCategory> createCategory(@RequestBody CategoryCreateDTO dto) {
        try {
            ProductCategory newCategory = categoryService.createCategory(dto);
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Trả về 400 và kèm thông báo lỗi để debug
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(null); // Hoặc .body(e.getMessage()) nếu muốn trả về thông báo lỗi String
        }
    }
    
    // Endpoint tạo Ngôn ngữ mới
    @PostMapping("/languages")
    public ResponseEntity<Language> createLanguage(@RequestParam String id, @RequestParam String name) {
        try {
            Language newLang = categoryService.createLanguage(id, name);
            return new ResponseEntity<>(newLang, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(null);
        }
    }
}