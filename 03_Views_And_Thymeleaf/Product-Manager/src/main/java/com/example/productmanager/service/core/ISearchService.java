package com.example.productmanager.service.core;

import java.util.List;

public interface ISearchService<E> {
    List<E> findByName(String string);
}
