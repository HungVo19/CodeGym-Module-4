package com.example.general_blog_manager.repository;

import com.example.general_blog_manager.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAllByTitleContaining(String string, Pageable pageable);
}
