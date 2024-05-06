package com.vti.loship.services;


import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.models.Category;
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
//        // co nghia la lay ra tat ca cac ban ghi co gia tri active = true
//        List<Category> listAll = categoryRepository.findAll();
//        List<Category> returnList = new ArrayList<>();
//        for(Category category: listAll)
//        {
//            if(category.isActive())
//            {
//                returnList.add(category);
//            }
//        }
//        return returnList;
    }





}
