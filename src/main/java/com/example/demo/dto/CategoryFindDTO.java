package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryFindDTO {
	 
	 	private Integer id;
	    private Boolean canBeShipped;
	    
	    private List<CategoryTranslationFindDTO> translations;

	    public CategoryFindDTO() {
	    }
	    
	    public CategoryFindDTO(Integer id, Boolean canBeShipped, List<CategoryTranslationFindDTO> translations) {
			super();
			this.id = id;
			this.canBeShipped = canBeShipped;
			this.translations = translations;
		}

		// Getters
	    public Boolean getCanBeShipped() {
	        return canBeShipped;
	    }

	    // Setters
	    public void setCanBeShipped(Boolean canBeShipped) {
	        this.canBeShipped = canBeShipped;
	    }

	    public List<CategoryTranslationFindDTO> getTranslations() {
	        return translations;
	    }

	    public void setTranslations(List<CategoryTranslationFindDTO> translations) {
	        this.translations = translations;
	    }
}

