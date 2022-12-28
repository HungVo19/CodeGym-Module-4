package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface ICustomerService  extends ICRUDService <Customer,Long>{
    Page<Customer> findAllByLastNameContaining(String firstname, Pageable pageable);
}
