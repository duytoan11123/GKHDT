package com.example.demo.service;

import com.example.demo.dto.CategoryCreateDTO;
import com.example.demo.dto.CategoryTranslationDTO;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.dto.CategoryFindDTO;
import com.example.demo.dto.CategoryTranslationFindDTO;
@Service
public class CategoryService {
    
    @Autowired private ProductCategoryRepository categoryRepository;
    @Autowired private LanguageRepository languageRepository;
    @Autowired private ProductCategoryTranslationRepository translationRepository; 
    
    // Phương thức tạo Category đã được sửa để gán ID thủ công
    @Transactional
    public ProductCategory createCategory(CategoryCreateDTO dto) {
        
        // 1. Tạo Entity Cha
        ProductCategory category = new ProductCategory();
        category.setCanBeShipped(dto.getCanBeShipped());
        
        // BƯỚC 1: LƯU ENTITY CHA để Hibernate cấp ID tự động tăng
        ProductCategory savedCategory = categoryRepository.save(category); 
        
        List<ProductCategoryTranslation> translationsToSave = new ArrayList<>();

        // 2. Chuẩn bị các bản dịch
        for (CategoryTranslationDTO transDto : dto.getTranslations()) {
            Language language = languageRepository.findById(transDto.getLanguageId())
                    .orElseThrow(() -> new RuntimeException("Language not found with ID: " + transDto.getLanguageId()));

            ProductCategoryTranslation translation = new ProductCategoryTranslation();
            
            // BƯỚC KHẮC PHỤC LỖI SQL: TẠO VÀ GÁN KHÓA TỔNG HỢP MỘT CÁCH THỦ CÔNG
            ProductCategoryTranslationId translationId = new ProductCategoryTranslationId(
                savedCategory.getProductCategoryId(),
                language.getLanguageId()
            );
            
            translation.setId(translationId); 

            // Gán các Entity tham chiếu
            translation.setCategory(savedCategory); 
            translation.setLanguage(language);
            translation.setCategoryName(transDto.getCategoryName());

            translationsToSave.add(translation);
        }
        
        // 3. LƯU TẤT CẢ BẢN DỊCH MỘT CÁCH RÕ RÀNG
        List<ProductCategoryTranslation> savedTranslations = translationRepository.saveAll(translationsToSave);

        // 4. Gán lại các bản dịch đã lưu vào Entity cha để trả về
        savedCategory.setTranslations(new HashSet<>(savedTranslations));
        
        return savedCategory; 
    }
    
    // Phương thức tạo Language
    @Transactional
    public Language createLanguage(String id, String name) {
        Language lang = new Language();
        lang.setLanguageId(id);
        lang.setLanguage(name);
        return languageRepository.save(lang);
    }
    
    public List<CategoryFindDTO> getAllProductCategory(){
    	List<CategoryFindDTO> resultCategories = new ArrayList<>();
    	List<ProductCategory> allCategory = new ArrayList<>();
    	allCategory = categoryRepository.findAll();
    	for (ProductCategory category: allCategory) {
    		List<CategoryTranslationFindDTO> translations = new ArrayList<>();
    		for (ProductCategoryTranslation translation: category.getTranslations()) {
        		translations.add(new CategoryTranslationFindDTO(translation.getLanguage().getLanguage(),translation.getCategoryName()));
    		}
    		resultCategories.add(new CategoryFindDTO(category.getProductCategoryId(),
    				category.getCanBeShipped(),translations));
    	}
    	return resultCategories;
    }
}