package com.blog_manager.service.impl;

import com.blog_manager.model.Blog;
import com.blog_manager.repository.IBlogRepository;
import com.blog_manager.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long aLong) {
        if (blogRepository.findById(aLong).isPresent()) {
            return blogRepository.findById(aLong).get();
        }
        return null;
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteById(Long aLong) {
        blogRepository.deleteById(aLong);
    }
}
