package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set; // Cần thiết cho Set<ProductTranslation>

@Entity
@Table(name = "Product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productId;

    // Sử dụng BigDecimal cho kiểu money/decimal(4,2)
    @Column(name = "Price") 
    private BigDecimal price;

    @Column(name = "Weight", precision = 4, scale = 2)
    private BigDecimal weight;

    // Khóa ngoại đến ProductCategory
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductCategoryID", nullable = false)
    private ProductCategory category;

    // THÊM MỐI QUAN HỆ DỊCH THUẬT VÀO ĐÂY
    // Sử dụng CascadeType.PERSIST để tương thích với logic lưu hai bước trong Service
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<ProductTranslation> translations = new HashSet<>(); 

    public Product() {}

    // Getters and Setters

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }
    
    public ProductCategory getCategory() { return category; }
    public void setCategory(ProductCategory category) { this.category = category; }

    // GETTER VÀ SETTER MỚI CHO TRANSLATIONS
    public Set<ProductTranslation> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<ProductTranslation> translations) {
        this.translations = translations;
    }
}