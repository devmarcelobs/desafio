package com.desafio.estagio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.estagio.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    Client findByItin(@Param("itin") String itin);
}
