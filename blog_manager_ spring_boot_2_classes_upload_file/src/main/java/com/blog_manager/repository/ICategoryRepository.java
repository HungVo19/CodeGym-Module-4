package com.blog_manager.repository;

import com.blog_manager.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
    Page<Category> searchByNameContaining(String name, Pageable pageable);
}
