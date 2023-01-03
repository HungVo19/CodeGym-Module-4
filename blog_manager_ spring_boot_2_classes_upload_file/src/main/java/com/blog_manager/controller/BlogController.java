package com.blog_manager.controller;

import com.blog_manager.model.Blog;
import com.blog_manager.model.Category;
import com.blog_manager.service.IBlogAlternativeService;
import com.blog_manager.service.IBlogService;
import com.blog_manager.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @ModelAttribute
    public ResponseEntity<Page<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(Pageable.unpaged()),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Blog>> list() {
        return new ResponseEntity<>(blogService.findAll(Pageable.unpaged()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog blog1 = blog;
        return new ResponseEntity<>(blogService.save(blog),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        blogService.deleteById(id);
        return new ResponseEntity<>("delete done",HttpStatus.OK);
    }
}
