package com.vti.loship.repositories;

import com.vti.loship.models.Category;
import org.apache.catalina.LifecycleState;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, Long>
{
    List<Category> findAllByActive(boolean active);

}
