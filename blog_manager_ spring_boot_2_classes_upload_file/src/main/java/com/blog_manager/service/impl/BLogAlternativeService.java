package com.blog_manager.service.impl;

import com.blog_manager.model.Blog;
import com.blog_manager.repository.IBlogRepository;
import com.blog_manager.service.IBlogAlternativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BLogAlternativeService implements IBlogAlternativeService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long aLong) {
        if (blogRepository.findById(aLong).isPresent()) {
            return blogRepository.findById(aLong).get();
        }
        return null;
    }

    @Override
    public void deleteById(Long aLong) {
        blogRepository.deleteById(aLong);
    }
}
