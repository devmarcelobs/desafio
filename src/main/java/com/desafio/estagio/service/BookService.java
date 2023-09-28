package com.desafio.estagio.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.desafio.estagio.model.Book;

public interface BookService {
    void createBook(Book book) throws DataIntegrityViolationException;
    List<Book> bookList();
    Book getBook(String title) throws ResourceNotFoundException;
}
