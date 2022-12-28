package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByLastNameContaining(String firstName, Pageable pageable);
}
