package com.example.productmanager.service.core;

import java.util.List;

public interface ICRUDService<E,K> {
    List<E> findAll();
    E findOne(K k);
    void save(E e);
    void deleteById(K k);
}
