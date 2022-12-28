package com.example.customer_manager.service;

import java.util.List;
import java.util.Optional;

public interface ICoreService <E,K>{
    List<E> findAll();
    Optional<E> findById(K k);
    E save(E e);
    void deleteById(K k);
}
