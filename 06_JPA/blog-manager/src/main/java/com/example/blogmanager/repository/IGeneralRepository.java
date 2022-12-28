package com.example.blogmanager.repository;

import java.util.List;

public interface IGeneralRepository <E,K>{
    List<E> findAll();
    E findById(K k);
    void save (E e);
    void remove(K k);
}
