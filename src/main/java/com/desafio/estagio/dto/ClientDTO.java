package com.desafio.estagio.dto;

import java.util.List;

import com.desafio.estagio.model.Book;

public class ClientDTO {
	private String name;
	private String lastName;
	private Float balance;
    private List<Book> books;

    public ClientDTO() {
    }

    public ClientDTO(String name, String lastName, Float balance, List<Book> books) {
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
        this.books = books;
    }

    public ClientDTO(String name, String lastName, Float balance) {
        this.name = name;
        this.lastName = lastName;
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getBalance() {
        return this.balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", balance='" + getBalance() + "'" +
            ", books='" + getBooks() + "'" +
            "}";
    }
}
