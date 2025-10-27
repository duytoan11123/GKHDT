package com.example.demo.dto;

public class CategoryTranslationFindDTO{
	public String language;
	public String categoryName;
	public String getLanguage() {
		return language;
	}
	public CategoryTranslationFindDTO(String language, String categoryName) {
		super();
		this.language = language;
		this.categoryName = categoryName;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
