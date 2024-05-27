package com.vti.loship.services;


import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.models.Category;
import com.vti.loship.models.ProductGroup;
import com.vti.loship.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    public Category create(Category category){
        Long id = sequenceGeneratorService.generateSequence(Category.SEQUENCE_NAME);
        category.setId(id);
        return categoryRepository.insert(category);
    }

    public Category update(Category categoryUpdate)
    {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryUpdate.getId());
        if(categoryOptional.isEmpty()){
            return null;
        }
        Category categoryFound = categoryOptional.get();
        categoryFound.setIcon(categoryUpdate.getIcon());
        categoryFound.setActive(true);
        categoryFound.setName(categoryUpdate.getName());
        return categoryRepository.save(categoryFound);
    }

    public Category softDelete(Long id){

        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isEmpty()){
            return null;
        }
        Category categoryFound = categoryOptional.get();
        categoryFound.setActive(false);
        return categoryRepository.save(categoryFound);
    }


    public boolean delete(Long id){
        categoryRepository.deleteById(id);
        return true;
    }

    public Category findById(Long id){
        Optional<Category> optional = categoryRepository.findById(id);
        if(optional.isEmpty()) return null;
        return optional.get();
    }


    public List<Category> findAll()
    {
        return categoryRepository.findAllByActive(true);
    }

    // Nguyen Huy - Bui The Tuong - Vu Duc Chien
    public List<ProductGroup> findAllProductGroupByCategoryID(Long categoryID)
    {
        return null;
    }

    // DUC PHAN - DUONG - HUNG DANG
    public Category addProductGroup(Long categoryID, ProductGroup productGroup){
        return null;
    }

    // HUNGW, HUYNH, PHAM CONG SON
    public Category removeProductGroup(Long categoryID, Long productGroupID){
        return null;
    }

    // QUYEN DINH PHAM - TRINH
    public Category updateProductGroup(Long categoryID, ProductGroup updateProductGroup){
        return null;
    }

    // DUC PHAN - DUONG - HUNG DANG
    public ProductGroup findProductGroupByID(Long categoryID, Long productGroupID){
        return null;
    }
}
