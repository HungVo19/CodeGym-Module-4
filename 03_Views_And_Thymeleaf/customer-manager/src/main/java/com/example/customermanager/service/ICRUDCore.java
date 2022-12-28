package com.example.customermanager.service;


import java.util.List;

public interface ICRUDCore<E,K> {
    List<E> findAll();

    E findOne(K k);

    void delete(K k);

    void save(E e);
}
