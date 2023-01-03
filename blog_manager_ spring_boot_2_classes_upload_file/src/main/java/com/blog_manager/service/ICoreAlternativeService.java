package com.blog_manager.service;

import java.util.List;

public interface ICoreAlternativeService <E,K>{
    List<E> findAll();
    E save(E e);
    E findById(K k);
    void deleteById(K k);
}
