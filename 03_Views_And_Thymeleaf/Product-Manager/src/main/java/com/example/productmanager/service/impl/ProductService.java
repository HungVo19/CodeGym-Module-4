package com.example.productmanager.service.impl;

import com.example.productmanager.model.Product;
import com.example.productmanager.service.interface_service.ICategoryService;
import com.example.productmanager.service.interface_service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends IProductService {
    private static ICategoryService categoryService;
    private static Long AUTO_ID;
    private static List<Product> products;

    static {
        categoryService = new CategoryService();
        AUTO_ID = 4L;
        products = new ArrayList<>();
        products.add(new Product(1L, "iPhone 14", 799D, categoryService.findAll().get(0)));
        products.add(new Product(2L, "iPad Pro", 899D, categoryService.findAll().get(1)));
        products.add(new Product(3L, "Macbook Air M2", 1099D, categoryService.findAll().get(2)));

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findOne(Long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(AUTO_ID++);
            products.add(product);
        } else {
            products.set(products.indexOf(findOne(product.getId())), product);
        }
    }

    @Override
    public void deleteById(Long id) {
        products.remove(findOne(id));
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product p:products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<Product> findByName(String string) {
        return null;
    }
}
