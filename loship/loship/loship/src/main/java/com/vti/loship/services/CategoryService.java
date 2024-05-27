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
        Optional<Category> optionalCategory = categoryRepository.findById(categoryID);
        if(optionalCategory.isEmpty()) return null;

        Category foundCategory = optionalCategory.get();
        return foundCategory.getProductGroupList();
    }

    // DUC PHAN - DUONG - HUNG DANG
    public Category addProductGroup(Long categoryID, ProductGroup productGroup){

        Optional<Category> optional = categoryRepository.findById(categoryID);
        if(optional.isEmpty()) return null;

        Category foundCategory = optional.get();

        List<ProductGroup> productGroupList = new ArrayList<>();
        productGroupList = foundCategory.getProductGroupList();


        Long id = sequenceGeneratorService.generateSequence(ProductGroup.SEQUENCE_NAME);
        productGroup.setId(id);
        productGroupList.add(productGroup);

        foundCategory.setProductGroupList(productGroupList);
        return categoryRepository.save(foundCategory);
    }

    // HUNGW, HUYNH, PHAM CONG SON
    public Category removeProductGroup(Long categoryID, Long productGroupID){

        Optional<Category> optional = categoryRepository.findById(categoryID);
        if(optional.isEmpty()) return null;

        Category found = optional.get();

        List<ProductGroup> productGroupList = new ArrayList<>();
        productGroupList = found.getProductGroupList();

        productGroupList.removeIf(productGroup -> productGroup.getId().equals(productGroupID));

        found.setProductGroupList(productGroupList);

        return categoryRepository.save(found);
    }

    // QUYEN DINH PHAM - TRINH
    // CHIEN
    public Category updateProductGroup(Long categoryID, ProductGroup updateProductGroup){

        Optional<Category> optional = categoryRepository.findById(categoryID);
        if(optional.isEmpty()) return null;
        Category found = optional.get();
        List<ProductGroup> productGroupList  = found.getProductGroupList();
        int count = 0;

        for(ProductGroup p: productGroupList)
        {
            if(p.getId().equals(updateProductGroup.getId()))
            {
                //index
                productGroupList.get(count).setName(updateProductGroup.getName());
                productGroupList.get(count).setActive(updateProductGroup.isActive());
                productGroupList.get(count).setCode(updateProductGroup.getCode());
                productGroupList.get(count).setDesc(updateProductGroup.getDesc());
            }
            count  = count ++;
        }

        found.setProductGroupList(productGroupList);
        return categoryRepository.save(found);
    }

    // DUC PHAN - DUONG - HUNG DANG
    public ProductGroup findProductGroupByID(Long categoryID, Long productGroupID){

        Optional<Category> optionalCategory = categoryRepository.findById(categoryID);
        if(optionalCategory.isEmpty()) return null;

        Category foundCategory = optionalCategory.get();
        for(ProductGroup p: foundCategory.getProductGroupList()){
            if(p.getId().equals(productGroupID)){
                return p;
            }
        }
        return null;
    }
}
