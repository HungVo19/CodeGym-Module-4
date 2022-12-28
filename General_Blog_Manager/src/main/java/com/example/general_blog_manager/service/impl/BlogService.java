package com.example.general_blog_manager.service.impl;

import com.example.general_blog_manager.model.Blog;
import com.example.general_blog_manager.repository.IBlogRepository;
import com.example.general_blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        if (blogRepository.findById(id).isPresent()) {
            return blogRepository.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteById(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findByNameContaining(String string, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(string,pageable);
    }
}
