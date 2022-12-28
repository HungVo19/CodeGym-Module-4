package com.example.phone_manager.service;

import com.example.phone_manager.model.Smartphone;
import com.example.phone_manager.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long aLong) {
        if (smartphoneRepository.findById(aLong).isPresent()) {
            return smartphoneRepository.findById(aLong);
        }
        return Optional.empty();
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    @Override
    public void deleteById(Long aLong) {
        smartphoneRepository.deleteById(aLong);
    }
}
