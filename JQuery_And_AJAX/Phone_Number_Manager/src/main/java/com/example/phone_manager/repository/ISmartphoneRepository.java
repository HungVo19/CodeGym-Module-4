package com.example.phone_manager.repository;

import com.example.phone_manager.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone,Long> {
}
