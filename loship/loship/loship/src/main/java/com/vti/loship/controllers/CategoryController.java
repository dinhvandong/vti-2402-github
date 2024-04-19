package com.vti.loship.controllers;

import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.repositories.CategoryRepository;
import com.vti.loship.responses.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, categoryRepository.findAll(),"token is blank"));
    }


}
