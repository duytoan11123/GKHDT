package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductCategoryTranslationId implements Serializable {

    @Column(name = "ProductCategoryID")
    private Integer productCategoryId; 

    @Column(name = "LanguageID")
    private String languageId;

    public ProductCategoryTranslationId() {}

    public ProductCategoryTranslationId(Integer productCategoryId, String languageId) {
        this.productCategoryId = productCategoryId;
        this.languageId = languageId;
    }

    // Getters and Setters
    public Integer getProductCategoryId() { return productCategoryId; }
    public void setProductCategoryId(Integer productCategoryId) { this.productCategoryId = productCategoryId; }
    public String getLanguageId() { return languageId; }
    public void setLanguageId(String languageId) { this.languageId = languageId; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryTranslationId that = (ProductCategoryTranslationId) o;
        return Objects.equals(productCategoryId, that.productCategoryId) &&
               Objects.equals(languageId, that.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCategoryId, languageId);
    }
}