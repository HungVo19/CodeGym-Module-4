package com.example.general_blog_manager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICoreService <E,K>{
    Page<E> findAll(Pageable pageable);
    Optional<E> findById(K k);
    void save(E e);
    void deleteById(K k);
}
