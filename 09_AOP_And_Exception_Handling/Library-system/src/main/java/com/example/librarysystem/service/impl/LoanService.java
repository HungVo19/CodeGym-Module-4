package com.example.librarysystem.service.impl;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.model.Loan;
import com.example.librarysystem.repository.ILoanRepository;
import com.example.librarysystem.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService implements ILoanService {
    @Autowired
    ILoanRepository loanRepository;

    @Override
    public Iterable<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public Optional<Loan> findById(Long aLong) {
        return loanRepository.findById(aLong);
    }

    @Override
    public void save(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public void deleteById(Long aLong) {
        loanRepository.deleteById(aLong);
    }

    @Override
    public Book findBookByCode(String code) {
        for (Loan l:loanRepository.findAll()) {
            if(l.getCode().equals(code)) {
                return l.getBook();
            }
        }
        return null;
    }

    @Override
    public void removeByCode(String code) {
        for (Loan l:loanRepository.findAll()) {
            if(l.getCode().equals(code)) {
                loanRepository.delete(l);
            }
        }
    }
}
