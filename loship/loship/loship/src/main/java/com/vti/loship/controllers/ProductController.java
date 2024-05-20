package com.vti.loship.controllers;

import com.vti.loship.models.Product;
import com.vti.loship.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findByCategory")
    public ResponseEntity<Page<Product>> getActiveProductsByCategory(
            @RequestParam("category") String categoryName,
            @RequestParam(value = "page", defaultValue = "0") int pageNumber,
            @RequestParam(value = "size", defaultValue = "10") int pageSize
    )
    {
        Page<Product> products = productService
                .getActiveProductsByCategory(categoryName, pageNumber, pageSize);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.create(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    // Add other API endpoints as needed

}
