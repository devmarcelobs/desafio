package com.desafio.estagio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.estagio.dto.ClientDTO;
import com.desafio.estagio.dto.InvoiceDTO;
import com.desafio.estagio.dto.TitleListDTO;
import com.desafio.estagio.model.Book;
import com.desafio.estagio.model.Client;
import com.desafio.estagio.repository.ClientRepository;
import com.desafio.estagio.service.BookService;
import com.desafio.estagio.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    private final BookService bookService;
    
    public ClientServiceImpl(ClientRepository clientRepository, BookService bookService){
        this.clientRepository = clientRepository;
        this.bookService = bookService;
    }

    @Override
    @Transactional
    public void createClient(Client client) throws DataIntegrityViolationException{
        Client clientAux = clientRepository.findByItin(client.getItin());

        if(clientAux == null){
            clientRepository.save(client);
        }
        else{
            throw new DataIntegrityViolationException("Usuário já existente!");
        }
    }

    @Override
    public InvoiceDTO buyBook(String itin, TitleListDTO titleListDTO) throws Exception {
        float value = 0;
        List<Book> bookList =  new ArrayList<>();

        Client client = clientRepository.findByItin(itin);

        for(String title : titleListDTO.getTitleList()){
            Book book = bookService.getBook(title);

            bookList.add(book);

            value += book.getPrice();
        }

        if(client.getBalance() >= value){
            client.setBalance(client.getBalance() - value);
            clientRepository.save(client);

            return new InvoiceDTO(client, bookList, value);
        }
        else{
            throw new Exception("Saldo insuficiente para a compra!");
        }
    }

    @Override
    @Transactional
    public ClientDTO incrementBalance(String itin, Float balance) throws ResourceNotFoundException {
        Client client = clientRepository.findByItin(itin);

        if(client != null){
            client.setBalance(client.getBalance() + balance);
            clientRepository.save(client);

            return new ClientDTO(client.getName(), client.getLastName(), client.getBalance());
        }
        else{
            throw new ResourceNotFoundException("Usuário não cadastrado!");
        }
    }
}