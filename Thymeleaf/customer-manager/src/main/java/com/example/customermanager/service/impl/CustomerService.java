package com.example.customermanager.service.impl;

import com.example.customermanager.model.Button;
import com.example.customermanager.model.Customer;
import com.example.customermanager.service.ICRUDCore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICRUDCore<Customer, Long> {

    static private ArrayList<Customer> list;
    static private ArrayList<Button> buttons;
    static private Long autoId = 4L;

    static {
        list = new ArrayList<>();
        list.add(new Customer(1L, "A", "a@email", "HN"));
        list.add(new Customer(2L, "B", "b@email", "NA"));
        list.add(new Customer(3L, "C", "c@email", "LC"));

        buttons = new ArrayList<>();
        buttons.add(new Button("Back"));
        buttons.add(new Button("Create"));
        buttons.add(new Button("Edit"));
    }

    @Override
    public ArrayList<Customer> findAll() {
        return list;
    }

    @Override
    public Customer findOne(Long id) {
        for (Customer c : list) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        list.remove(findOne(id));
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(autoId++);
            list.add(customer);
        } else {
//            Customer customerToUpdate = findOne(customer.getId());
            list.set(list.indexOf(findOne(customer.getId())),customer );
        }
    }

    public ArrayList<Button> findAllButtons () {
        return buttons;
    }


}
