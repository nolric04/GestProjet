package com.example.gestionprojet.bll.manager.projet.task;

import com.example.gestionprojet.bll.manager.AbstractManager;
import com.example.gestionprojet.bll.manager.projet.ProjetManagerInterface;
import com.example.gestionprojet.bo.ProjectTask;
import com.example.gestionprojet.bo.Projet;
import com.example.gestionprojet.dal.ProjectTaskDAO;
import com.example.gestionprojet.dal.ProjetDAO;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskManager extends AbstractManager<ProjectTask, ProjectTaskDAO> implements ProjectTaskManagerInterface {
}
