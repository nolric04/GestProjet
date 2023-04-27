package com.example.gestionprojet.dal;

import com.example.gestionprojet.bo.Client;
import com.example.gestionprojet.bo.Entreprise;
import org.springframework.data.repository.CrudRepository;

public interface EntrepriseDAO extends CrudRepository<Entreprise, Long> {
}
