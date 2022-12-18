package com.example.customermanager.service.impl;

import com.example.customermanager.model.Customer;
import com.example.customermanager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class HibernateCustomerServiceImpl implements ICustomerService {

    @Autowired
    private EntityManager entityManager;
    @Override
    public ArrayList<Customer> findAll() {
        String queryStr = "SELECT C FROM Customer AS C ";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return (ArrayList<Customer>) query.getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(long id) {

    }
}
