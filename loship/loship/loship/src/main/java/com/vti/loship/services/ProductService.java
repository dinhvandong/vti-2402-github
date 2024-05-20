package com.vti.loship.services;


import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.models.Product;
import com.vti.loship.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    public Product create(Product product){
        Long id = sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME);
        product.setId(id);
        return productRepository.insert(product);
    }

    public List<Product> findAll(){
        return productRepository.findAllByActive(true);
    }

    public List<Product> findAllByCategory(String category){
        return productRepository.findAllByCategoryNameAndActive(category, true);
    }


    public Page<Product> getActiveProductsByCategory(String categoryName, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findByCategoryNameAndActive(categoryName, true, pageable);
    }


}
