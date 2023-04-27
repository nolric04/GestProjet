package com.example.gestionprojet.dal;

import com.example.gestionprojet.bo.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Long> {
}
