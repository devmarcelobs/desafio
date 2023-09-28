package com.desafio.estagio.model;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Nome não pode ser vazio!")
    private String name;
    @NotEmpty(message = "Sobrenome não pode ser vazio!")
    private String lastName;
    @NotEmpty(message = "CPF não pode ser vazio!")
    @CPF(message = "CPF em formato inválido!")
    private String itin;
    @NotEmpty(message = "E-mail não pode ser vazio!")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Email em formato inválido!")
    private String email;
    private Float balance;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    public Client() {
    }

    public Client(String name, String lastName, String itin, String email, Float balance) {
        this.name = name;
        this.lastName = lastName;
        this.itin = itin;
        this.email = email;
        this.balance = balance;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getItin() {
        return this.itin;
    }

    public void setItin(String itin) {
        this.itin = itin;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getBalance() {
        return this.balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public List<Book> getBookList() {
        return this.bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", itin='" + getItin() + "'" +
            ", email='" + getEmail() + "'" +
            ", balance='" + getBalance() + "'" +
            ", bookList='" + getBookList() + "'" +
            "}";
    }
}
