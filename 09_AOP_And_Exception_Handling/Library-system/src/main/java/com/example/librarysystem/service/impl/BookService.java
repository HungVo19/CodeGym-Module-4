package com.example.librarysystem.service.impl;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.repository.IBookRepository;
import com.example.librarysystem.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long aLong) {
        return bookRepository.findById(aLong);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Long aLong) {
        bookRepository.deleteById(aLong);
    }
}
