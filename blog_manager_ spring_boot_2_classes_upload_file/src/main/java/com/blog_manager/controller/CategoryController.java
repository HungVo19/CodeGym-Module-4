package com.blog_manager.controller;

import com.blog_manager.model.Category;
import com.blog_manager.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> list(@PageableDefault(value = 2) Pageable pageable) {
            return new ResponseEntity<>(categoryService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/search/{q}")
    public ResponseEntity<Page<Category>> listSearch(@PathVariable String q,@PageableDefault(value = 2) Pageable pageable) {
        Page<Category> page = categoryService.searchByNameContaining(q,pageable);
            return new ResponseEntity<>(categoryService.searchByNameContaining(q,pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        Category categoryUpdate = categoryService.findById(id);
        category.setId(categoryUpdate.getId());
        return new ResponseEntity<>(categoryService.save(category),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>("Delete done!",HttpStatus.OK);
    }
}
