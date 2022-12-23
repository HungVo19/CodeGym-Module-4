package com.example.librarysystem.service;

import java.util.Optional;

public interface ICoreCRUDService <E,K>{
    Iterable<E> findAll();
    Optional<E> findById(K k);
    void save(E e);
    void deleteById(K k);
}
