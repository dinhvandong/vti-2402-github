package com.vti.loship.repositories;

import com.vti.loship.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, Long> {
}
