package com.vti.loship.database;


import com.vti.loship.models.Category;
import com.vti.loship.models.User;
import com.vti.loship.repositories.CategoryRepository;
import com.vti.loship.repositories.UserRepository;
import com.vti.loship.security.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class Database {
    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   CategoryRepository categoryRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user = new User();
              //  user.setId(1L);
                Long id = sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME);
                user.setId(id);
                user.setEmail("admin@gmail.com");
                user.setPhone("84965741051");
                user.setPassword(PasswordEncoder.getInstance().encodePassword("A123456a@"));
                user.setStatus(1);
              //  userRepository.deleteAll();
                if(userRepository.findAll().isEmpty())
                    userRepository.insert(user);
               // categoryRepository.deleteAll();

//                Category category1 = new Category();
//                category1.setId(1L);
//                category1.setName("Ăn trưa");
//                category1.setActive(true);
//                category1.setIcon("http://localhost:8080/api/images/1");
//
//
//                Category category2 = new Category();
//                category2.setId(2L);
//                category2.setName("Ăn sáng");
//                category2.setActive(true);
//                category2.setIcon("http://localhost:8080/api/images/1");
//
//
//                Category category3 = new Category();
//                category3.setId(3L);
//                category3.setName("Ăn tối");
//                category3.setActive(true);
//                category3.setIcon("http://localhost:8080/api/images/1");
//
//                if(categoryRepository.findAll().isEmpty()){
//                    categoryRepository.insert(category1);
//                    categoryRepository.insert(category2);
//                    categoryRepository.insert(category3);
//                }
            }
        };
    }
}
