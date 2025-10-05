package com.example.demo.repository;

import com.example.demo.model.ProductCategoryTranslation;
import com.example.demo.model.ProductCategoryTranslationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryTranslationRepository 
    extends JpaRepository<ProductCategoryTranslation, ProductCategoryTranslationId> {}