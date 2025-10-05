package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    
    @Autowired private ProductRepository productRepository;
    @Autowired private ProductCategoryRepository categoryRepository;
    @Autowired private LanguageRepository languageRepository;
    // BẮT BUỘC: Autowired Repository mới để lưu bản dịch
    @Autowired private ProductTranslationRepository translationRepository; 

    @Transactional
    public Product createProduct(ProductCreateDTO dto) {
        
        // 1. Tìm và kiểm tra FK
        ProductCategory category = categoryRepository.findById(dto.getProductCategoryId())
                .orElseThrow(() -> new RuntimeException("ProductCategory not found with ID: " + dto.getProductCategoryId()));
        
        // 2. Tạo Entity Product cơ bản
        Product product = new Product();
        product.setPrice(dto.getPrice());
        product.setWeight(dto.getWeight());
        product.setCategory(category);
        
        // BƯỚC 1: LƯU ENTITY CHA để Hibernate cấp ProductID
        Product savedProduct = productRepository.save(product); 
        
        List<ProductTranslation> translationsToSave = new ArrayList<>();

        // 3. Chuẩn bị và Gán Khóa Tổng hợp cho các bản dịch
        for (ProductTranslationDTO transDto : dto.getTranslations()) {
            Language language = languageRepository.findById(transDto.getLanguageId())
                    .orElseThrow(() -> new RuntimeException("Language not found with ID: " + transDto.getLanguageId()));

            ProductTranslation translation = new ProductTranslation();
            
            // BƯỚC KHẮC PHỤC LỖI: TẠO VÀ GÁN KHÓA TỔNG HỢP MỘT CÁCH THỦ CÔNG
            ProductTranslationId translationId = new ProductTranslationId(
                savedProduct.getProductId(), // SỬ DỤNG ID ĐÃ CÓ
                language.getLanguageId()
            );
            
            translation.setId(translationId); // Gán Khóa Tổng hợp
            
            // Gán Entity tham chiếu
            translation.setProduct(savedProduct); 
            translation.setLanguage(language);

            // Thiết lập dữ liệu dịch thuật
            translation.setProductName(transDto.getProductName());
            translation.setProductDescription(transDto.getProductDescription());

            translationsToSave.add(translation);
        }
        
        // 4. LƯU TẤT CẢ BẢN DỊCH MỘT CÁCH RÕ RÀNG
        List<ProductTranslation> savedTranslations = translationRepository.saveAll(translationsToSave);
        
        // 5. Gán lại các bản dịch đã lưu vào Entity cha để trả về
        savedProduct.setTranslations(new HashSet<>(savedTranslations));
        
        return savedProduct; 
    }
}