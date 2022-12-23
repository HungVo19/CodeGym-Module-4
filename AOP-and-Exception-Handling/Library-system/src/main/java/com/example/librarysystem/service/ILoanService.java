package com.example.librarysystem.service;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.model.Loan;
import com.example.librarysystem.service.ICoreCRUDService;

public interface ILoanService extends ICoreCRUDService<Loan, Long> {
    Book findBookByCode(String code);

    void removeByCode(String code);
}
