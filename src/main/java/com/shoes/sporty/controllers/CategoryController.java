package com.shoes.sporty.controllers;

import com.shoes.sporty.models.Category;
import com.shoes.sporty.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping()
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = service.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping()
    public Category save(@RequestBody Category category){
        return service.save(category);
    }
}
