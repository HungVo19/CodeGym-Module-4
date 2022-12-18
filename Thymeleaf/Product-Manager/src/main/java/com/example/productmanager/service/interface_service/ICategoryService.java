package com.example.productmanager.service.interface_service;

import com.example.productmanager.model.Category;
import com.example.productmanager.service.core.ICRUDService;
import com.example.productmanager.service.core.ISearchService;

public abstract class ICategoryService implements ICRUDService<Category,Long>, ISearchService<Category> {
}
