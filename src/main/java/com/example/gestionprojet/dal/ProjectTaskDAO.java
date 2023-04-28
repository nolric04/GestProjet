package com.example.gestionprojet.dal;

import com.example.gestionprojet.bo.ProjectTask;
import com.example.gestionprojet.bo.Projet;
import org.springframework.data.repository.CrudRepository;

public interface ProjectTaskDAO extends CrudRepository<ProjectTask, Long> {
}
