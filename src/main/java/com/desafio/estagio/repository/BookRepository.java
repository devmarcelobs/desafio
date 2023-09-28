package com.desafio.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.estagio.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(@Param("title") String title);
}
