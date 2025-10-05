package com.example.demo.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductCreateDTO {
    private BigDecimal price;
    private BigDecimal weight;
    private Integer productCategoryId; // Khóa ngoại
    private List<ProductTranslationDTO> translations;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public List<ProductTranslationDTO> getTranslations() {
        return translations;
    }

    public void setTranslations(List<ProductTranslationDTO> translations) {
        this.translations = translations;
    }
}