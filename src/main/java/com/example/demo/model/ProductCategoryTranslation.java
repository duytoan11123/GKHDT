package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductCategoryTranslation")
public class ProductCategoryTranslation {

    @EmbeddedId
    private ProductCategoryTranslationId id;

    @Column(name = "CategoryName", length = 100, nullable = false) // varchar(100)
    private String categoryName;
    
    // Tắt insertable/updatable để Service gán ID thủ công (giải quyết lỗi SQL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductCategoryID", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private ProductCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LanguageID", nullable = false, insertable = false, updatable = false) 
    private Language language;

    public ProductCategoryTranslation() {}

    // Getters and Setters
    public ProductCategoryTranslationId getId() { return id; }
    public void setId(ProductCategoryTranslationId id) { this.id = id; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public ProductCategory getCategory() { return category; }
    public void setCategory(ProductCategory category) { this.category = category; }
    public Language getLanguage() { return language; }
    public void setLanguage(Language language) { this.language = language; }
}