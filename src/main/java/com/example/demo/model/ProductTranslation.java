package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductTranslation")
public class ProductTranslation {

    @EmbeddedId
    private ProductTranslationId id;

    @Column(name = "ProductName", length = 100, nullable = false) // varchar(100)
    private String productName;

    @Column(name = "ProductDescription", length = 100) // varchar(100)
    private String productDescription;
    
    // Tắt insertable/updatable để Service gán ID thủ công (tương tự như Category)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false, insertable = false, updatable = false) 
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LanguageID", nullable = false, insertable = false, updatable = false) 
    private Language language;

    public ProductTranslation() {}

    // Getters and Setters
    public ProductTranslationId getId() { return id; }
    public void setId(ProductTranslationId id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductDescription() { return productDescription; }
    public void setProductDescription(String productDescription) { this.productDescription = productDescription; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Language getLanguage() { return language; }
    public void setLanguage(Language language) { this.language = language; }
}