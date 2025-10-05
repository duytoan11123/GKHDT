package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTranslationDTO {
    
    @JsonProperty("languageId")
    private String languageId;
    
    @JsonProperty("categoryName")
    private String categoryName;

    public CategoryTranslationDTO() {
    }
    
    // Getters
    public String getLanguageId() {
        return languageId;
    }

    // Setters
    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}