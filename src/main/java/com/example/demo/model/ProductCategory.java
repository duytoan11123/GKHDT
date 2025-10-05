package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductCategoryID")
    private Integer productCategoryId;

    // Sử dụng Boolean cho 'bit'
    @Column(name = "CanBeShipped") 
    private Boolean canBeShipped; 

    // Mối quan hệ với Dịch thuật Danh mục (PERSIST để kiểm soát thủ công)
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<ProductCategoryTranslation> translations = new HashSet<>();
    
    // Mối quan hệ với Sản phẩm
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

    public ProductCategory() {}

    // Getters and Setters
    public Integer getProductCategoryId() { return productCategoryId; }
    public void setProductCategoryId(Integer productCategoryId) { this.productCategoryId = productCategoryId; }
    public Boolean getCanBeShipped() { return canBeShipped; }
    public void setCanBeShipped(Boolean canBeShipped) { this.canBeShipped = canBeShipped; }
    public Set<ProductCategoryTranslation> getTranslations() { return translations; }
    public void setTranslations(Set<ProductCategoryTranslation> translations) { this.translations = translations; }
    public Set<Product> getProducts() { return products; }
    public void setProducts(Set<Product> products) { this.products = products; }
}