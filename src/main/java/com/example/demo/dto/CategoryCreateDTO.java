package com.example.demo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CategoryCreateDTO {
    
    @JsonProperty("canBeShipped")
    private Boolean canBeShipped;

    @JsonProperty("translations")
    private List<CategoryTranslationDTO> translations;

    public CategoryCreateDTO() {
    }
    
    // Getters
    public Boolean getCanBeShipped() {
        return canBeShipped;
    }

    // Setters
    public void setCanBeShipped(Boolean canBeShipped) {
        this.canBeShipped = canBeShipped;
    }

    public List<CategoryTranslationDTO> getTranslations() {
        return translations;
    }

    public void setTranslations(List<CategoryTranslationDTO> translations) {
        this.translations = translations;
    }
}