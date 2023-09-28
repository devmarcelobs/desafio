package com.desafio.estagio.service.impl;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.estagio.model.Book;
import com.desafio.estagio.repository.BookRepository;
import com.desafio.estagio.service.BookService;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    
    @Override
    @Transactional
    public void createBook(Book book) throws DataIntegrityViolationException {
        Book bookAux = bookRepository.findByTitle(book.getTitle());
        
        if(bookAux == null){
            bookRepository.save(book);
        }
        else{
            throw new DataIntegrityViolationException("Livro já cadastrado!");
        }
    }

    @Override
    public List<Book> bookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(String title) throws ResourceNotFoundException {
        try{
            return bookRepository.findByTitle(title);
        } catch(ResourceNotFoundException e){
            throw new ResourceNotFoundException("Livro não encontrado!");
        }
    }
}
