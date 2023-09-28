package com.desafio.estagio.dto;

public class ClientDTO {
	private String name;
	private String lastName;
	private Float balance;

    public ClientDTO() {
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
}
