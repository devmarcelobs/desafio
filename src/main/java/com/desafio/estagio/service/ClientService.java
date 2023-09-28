package com.desafio.estagio.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.desafio.estagio.dto.ClientDTO;
import com.desafio.estagio.dto.InvoiceDTO;
import com.desafio.estagio.dto.TitleListDTO;
import com.desafio.estagio.model.Client;

public interface ClientService {
    void createClient(Client client) throws DataIntegrityViolationException;
    InvoiceDTO buyBook(String itin, TitleListDTO titleListDTO) throws Exception;
    ClientDTO incrementBalance(String itin, Float balance) throws ResourceNotFoundException;
    ClientDTO getClient(String itin);
}
