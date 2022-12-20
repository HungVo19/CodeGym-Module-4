package com.example.blogmanager.service;

import java.util.List;

public interface ICoreService <E,K>{
    List<E> findAll();
    E findById(K k);
    void save (E e);
    void remove(K k);
}
