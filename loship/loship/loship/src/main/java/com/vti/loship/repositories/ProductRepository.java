package com.vti.loship.repositories;

import com.vti.loship.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Long>
{
    public List<Product> findAllByCategoryNameAndActive(String categoryName, boolean active);
    public List<Product> findAllByActive (boolean active);
    Page<Product> findByCategoryNameAndActive(String categoryName, boolean active, Pageable pageable);

}
