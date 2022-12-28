package com.example.customermanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface ICRUDService <E,K>{
    Page<E> findAll(Pageable pageable);
    Optional<E> findById(K k);
    void save(E e);
    void remove(K k);
}
