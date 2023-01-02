package com.blog_manager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICoresService<E, K> {
    Page<E> findAll(Pageable pageable);

    E findById(K k);

    E save(E e);

    void deleteById(K k);
}
