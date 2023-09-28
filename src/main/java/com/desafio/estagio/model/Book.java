package com.desafio.estagio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String title;
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String author;
    private Float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Client> clients;

    public Book() {
    }

    public Book(String title, String author, Float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }   

    public Book(String title, String author, Float price, List<Client> clients) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.clients = clients;
    }    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", price='" + getPrice() + "'" +
            ", clients='" + getClients() + "'" +
            "}";
    }
}
