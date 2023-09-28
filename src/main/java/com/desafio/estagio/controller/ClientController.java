package com.desafio.estagio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.desafio.estagio.dto.ClientDTO;
import com.desafio.estagio.dto.InvoiceDTO;
import com.desafio.estagio.dto.TitleListDTO;
import com.desafio.estagio.model.Client;
import com.desafio.estagio.service.ClientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping(value = "/createClient")
    public ResponseEntity<Object> createClient(@RequestBody @Valid Client client){
        clientService.createClient(client);

        return ResponseEntity.created(null).build();
    }

    @PostMapping(value = "/buyBook")
    public ResponseEntity<InvoiceDTO> buyBook(@RequestParam("itin") String itin, @RequestBody TitleListDTO titleListDto) throws Exception{
        InvoiceDTO invoice = clientService.buyBook(itin, titleListDto);

        return ResponseEntity.ok().body(invoice);
    }

    @PatchMapping(value = "/incrementBalance")
    public ResponseEntity<ClientDTO> incrementBalance(@RequestParam("itin") String itin, @RequestParam("balance") float balance){
        ClientDTO clientDto = clientService.incrementBalance(itin, balance);

        return ResponseEntity.ok().body(clientDto);
    }

    @GetMapping(value = "/getClient")
    public ResponseEntity<ClientDTO> getClient(@RequestParam("itin") String itin){
        ClientDTO clientDto = clientService.getClient(itin);

        return ResponseEntity.ok().body(clientDto);
    }
}
