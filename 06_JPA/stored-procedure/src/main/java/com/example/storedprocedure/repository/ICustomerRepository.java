package com.example.storedprocedure.repository;

import com.example.storedprocedure.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
