package com.example.general_blog_manager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService <E,K>{
    Page<E> findByNameContaining(String string,Pageable pageable);
}
