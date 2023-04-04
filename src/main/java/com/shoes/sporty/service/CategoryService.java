package com.shoes.sporty.service;

import com.shoes.sporty.models.Category;
import com.shoes.sporty.reposotory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public Category save(Category category){
        Optional<Category> categoryOptional = repository.findByName(category.getName());
        return categoryOptional.orElseGet(() -> repository.save(category));
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getOne(Integer id){
        return repository.findById(id);
    }
}
