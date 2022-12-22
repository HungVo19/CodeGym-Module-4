package com.example.storedprocedure.service;

import com.example.storedprocedure.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
