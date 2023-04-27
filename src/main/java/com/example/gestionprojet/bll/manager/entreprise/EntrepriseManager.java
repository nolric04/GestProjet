package com.example.gestionprojet.bll.manager.entreprise;

import com.example.gestionprojet.bll.manager.AbstractManager;
import com.example.gestionprojet.bo.Entreprise;
import com.example.gestionprojet.dal.EntrepriseDAO;
import org.springframework.stereotype.Service;

@Service
public class EntrepriseManager extends AbstractManager<Entreprise, EntrepriseDAO> implements EntrepriseManagerInterface {
}
