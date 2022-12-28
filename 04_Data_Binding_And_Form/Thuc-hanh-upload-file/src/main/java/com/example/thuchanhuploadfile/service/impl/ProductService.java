package com.example.thuchanhuploadfile.service.impl;

import com.example.thuchanhuploadfile.model.Product;
import com.example.thuchanhuploadfile.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private List<Product> products = new ArrayList<>();
    private static Long AUTO_ID = 0L;

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if(product.getId() == null){
            product.setId(AUTO_ID++);
            products.add(product);
        } else {
            products.set(products.indexOf(findById(product.getId())),product );
        }
    }

    @Override
    public Product findById(Long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void remove(Long id) {
        products.remove(findById(id));
    }
}
