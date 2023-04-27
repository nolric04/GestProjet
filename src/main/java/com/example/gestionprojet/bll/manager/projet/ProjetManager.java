package com.example.gestionprojet.bll.manager.projet;

import com.example.gestionprojet.bll.manager.AbstractManager;
import com.example.gestionprojet.bo.Projet;
import com.example.gestionprojet.dal.ProjetDAO;
import org.springframework.stereotype.Service;

@Service
public class ProjetManager extends AbstractManager<Projet, ProjetDAO> implements ProjetManagerInterface{
}
