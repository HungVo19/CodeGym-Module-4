package com.blog_manager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <E>{
    Page<E> searchByNameContaining(String name, Pageable pageable);
}
