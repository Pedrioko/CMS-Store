package com.pedrioko.github.cmsapi.controllers;

import com.pedrioko.github.cmsapi.domain.Category;
import com.pedrioko.github.cmsapi.exceptions.CategoryNotFoundException;
import com.pedrioko.github.cmsapi.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    public List<Category> all() {
        return categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public Category newCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @GetMapping("/categories/{id}")
    public Category one(@PathVariable Long id) {

        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @PutMapping("/categories/{id}")
    public Category updateEmployee(@RequestBody Category category, @PathVariable Long id) {

        return categoryRepository.findById(id)
                .map(category_old -> {
                    category_old.setName(category.getName());
                    category_old.setImage(category.getImage());
                    category_old.setParent_category(category.getParent_category());
                    return categoryRepository.save(category_old);
                })
                .orElseGet(() -> {
                    category.setId(id);
                    return categoryRepository.save(category);
                });
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
    }
}
