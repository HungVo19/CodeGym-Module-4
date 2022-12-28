package com.example.customermanager.service;

import com.example.customermanager.exception.DuplicateEmailException;

import java.util.Optional;

public interface ICRUDCoreService <E,K>{
    Iterable<E> findAll();
    Optional<E> findById(K k) throws Exception;
    void save (E e) throws Exception;
    void deleteById(K k);
}
