package com.example.customermanager.service;

import com.example.customermanager.model.Customer;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {
    ArrayList<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);

    void remove(long id);
}
