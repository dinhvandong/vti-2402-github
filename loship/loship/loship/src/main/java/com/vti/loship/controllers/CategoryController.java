package com.vti.loship.controllers;

import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.jwt.JwtInterceptor;
import com.vti.loship.models.Category;
import com.vti.loship.repositories.CategoryRepository;
import com.vti.loship.responses.ResponseObject;
import com.vti.loship.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, categoryService.findAll(),"success"));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Category category)
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, categoryService.create(category),"success"));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Category category)
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, categoryService.update(category),"success"));
    }
    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, categoryService.findById(id),"success"));
    }
    @GetMapping("/soft_delete")
    public ResponseEntity<?> softDelete(@RequestParam Long id, @RequestParam String token)
    {
        if(token.isBlank()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(201, null,"token is blank"));
        }
        token = "Bearer " + token;
        boolean isAuthenticated = JwtInterceptor.getInstance().isValidToken(token);
        if(isAuthenticated)
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, categoryService.softDelete(id),"success"));
        }else
        {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(202, null,"token is invalid"));

        }

    }

    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(200, categoryService.delete(id),"success"));
    }

}
