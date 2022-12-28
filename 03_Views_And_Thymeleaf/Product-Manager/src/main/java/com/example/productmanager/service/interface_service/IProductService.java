package com.example.productmanager.service.interface_service;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.core.ICRUDService;
import com.example.productmanager.service.core.ISearchService;

import java.util.List;

public abstract class IProductService implements ICRUDService<Product,Long>, ISearchService<Product> {
    public abstract List<Product> searchByName(String name);
}
