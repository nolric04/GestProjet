package com.example.gestionprojet.dal;

import com.example.gestionprojet.bo.Client;
import com.example.gestionprojet.bo.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeDAO extends CrudRepository<Employe, Long> {
}
