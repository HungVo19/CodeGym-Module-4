package com.blog_manager.service.impl;

import com.blog_manager.model.Category;
import com.blog_manager.repository.ICategoryRepository;
import com.blog_manager.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Long aLong) {
        if(categoryRepository.findById(aLong).isPresent()) {
            return categoryRepository.findById(aLong).get();
        }
        return null;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long aLong) {
        categoryRepository.deleteById(aLong);
    }

    @Override
    public Page<Category> searchByNameContaining(String name,Pageable pageable) {
        return categoryRepository.searchByNameContaining(name,pageable);
    }
}
