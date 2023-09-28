package com.desafio.estagio.dto;

import java.util.List;

import com.desafio.estagio.model.Book;

public class InvoiceDTO {
    private ClientDTO clientDto;
    private List<Book> books;
    private Float value;

    public InvoiceDTO() {
    }

    public InvoiceDTO(ClientDTO clientDto, List<Book> books, Float value) {
        this.clientDto = clientDto;
        this.books = books;
        this.value = value;
    }

    public ClientDTO getClientDto() {
        return this.clientDto;
    }

    public void setClientDto(ClientDTO clientDto) {
        this.clientDto = clientDto;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Float getValue() {
        return this.value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
            " clientDto='" + getClientDto() + "'" +
            ", books='" + getBooks() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
}
