package com.example.gestionprojet.dal;

import com.example.gestionprojet.bo.Client;
import com.example.gestionprojet.bo.Projet;
import org.springframework.data.repository.CrudRepository;

public interface ProjetDAO extends CrudRepository<Projet, Long> {
}
