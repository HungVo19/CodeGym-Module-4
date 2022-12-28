package com.example.general_blog_manager.repository;

import com.example.general_blog_manager.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag,Long> {
}
