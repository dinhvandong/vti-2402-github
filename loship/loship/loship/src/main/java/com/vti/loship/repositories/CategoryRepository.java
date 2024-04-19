package com.vti.loship.repositories;

import com.vti.loship.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, Long>
{



}
