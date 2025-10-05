package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Language")
public class Language {

    @Id
    @Column(name = "LanguageID", length = 2) // char(2)
    private String languageId;

    @Column(name = "Language", length = 20, nullable = false) // varchar(20)
    private String language;

    public Language() {}

    // Getters and Setters
    public String getLanguageId() { return languageId; }
    public void setLanguageId(String languageId) { this.languageId = languageId; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}