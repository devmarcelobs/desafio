package com.desafio.estagio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafio.estagio.model.Book;
import com.desafio.estagio.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping(value = "/createBook")
    public ResponseEntity<?> createBook(@RequestBody @Valid Book book){
        bookService.createBook(book);

        return ResponseEntity.created(null).build();
    }

    @GetMapping(value = "/bookList")
    public ResponseEntity<List<Book>> bookList(){
        List<Book> bookList = bookService.bookList();

        return ResponseEntity.ok().body(bookList);
    }

    @GetMapping(value = "/getBook")
    public ResponseEntity<Book> getBook(@RequestParam("title") String title){
        Book book = bookService.getBook(title);

        return ResponseEntity.ok().body(book);
    }
}
