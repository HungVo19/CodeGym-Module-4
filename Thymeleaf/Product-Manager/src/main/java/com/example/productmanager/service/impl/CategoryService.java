package com.example.productmanager.service.impl;

import com.example.productmanager.model.Category;
import com.example.productmanager.service.interface_service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends ICategoryService {
    private static List<Category> categories;
    static {
        categories = new ArrayList<>();
        categories.add(new Category(1L,"iPhone"));
        categories.add(new Category(2L,"iPad"));
        categories.add(new Category(3L,"Macbook"));
    }
    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category findOne(Long aLong) {
        return null;
    }

    public Category findOneByName(String name) {
        for(Category c: categories) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Category> findByName(String string) {
        return null;
    }
}
