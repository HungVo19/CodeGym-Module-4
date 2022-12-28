package com.example.phone_manager.service;

import com.example.phone_manager.model.Smartphone;

import java.util.Optional;

public interface ICoreService <E,K>{
    Iterable<Smartphone> findAll();
    Optional<Smartphone> findById(K k);
    E save(E e);
    void deleteById(K k);
}
