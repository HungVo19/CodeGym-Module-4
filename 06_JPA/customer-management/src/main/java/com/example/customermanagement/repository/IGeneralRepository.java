package com.example.customermanagement.repository;

import java.util.List;

public interface IGeneralRepository<O,L> {
    List<O> findAll();
    O findById(L l);
    void save(O o);
    void remove(L l);
}
