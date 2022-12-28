package com.example.customermanagement.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ICRUDService <E,K>{
    List<E> findAll();
    E findById(K k);
    void save(E e);
    void remove(K k);
}
