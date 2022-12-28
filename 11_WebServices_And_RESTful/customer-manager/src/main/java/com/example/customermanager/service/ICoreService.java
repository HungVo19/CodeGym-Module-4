package com.example.customermanager.service;

import java.util.Optional;

public interface ICoreService <E,K>{
    Iterable<E> findAll();
    Optional<E> findByID(K k);
    E save(E e);
    void remove(K k);
}
