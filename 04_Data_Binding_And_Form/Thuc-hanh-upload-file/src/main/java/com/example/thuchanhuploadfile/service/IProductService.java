package com.example.thuchanhuploadfile.service;

import com.example.thuchanhuploadfile.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void remove(Long id);
}
