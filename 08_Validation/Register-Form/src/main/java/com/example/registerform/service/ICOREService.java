package com.example.registerform.service;

public interface ICOREService<T,K> {
    Iterable<T> findAll();
    T findById (K k);
    void save (T t);
    void deleteById (K k);
}
