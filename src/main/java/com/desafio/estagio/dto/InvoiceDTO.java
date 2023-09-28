package com.desafio.estagio.dto;

import java.util.List;

import com.desafio.estagio.model.Book;
import com.desafio.estagio.model.Client;

public class InvoiceDTO {
    private Client client;
    private List<Book> list;
    private Float value;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Client client, List<Book> list, Float value) {
        this.client = client;
        this.list = list;
        this.value = value;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Book> getList() {
        return this.list;
    }

    public Float getValue() {
        return this.value;
    }

    public void setUser(Client client) {
        this.client = client;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
