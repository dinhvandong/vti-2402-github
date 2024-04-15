package com.vti.loship.repositories;

import com.vti.loship.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByEmail (String email);
    Optional<User> findByPhone (String phone);


}
