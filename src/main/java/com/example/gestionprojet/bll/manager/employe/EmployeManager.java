package com.example.gestionprojet.bll.manager.employe;

import com.example.gestionprojet.bll.manager.AbstractManager;
import com.example.gestionprojet.bo.Employe;
import com.example.gestionprojet.dal.EmployeDAO;
import org.springframework.stereotype.Service;

@Service
public class EmployeManager extends AbstractManager<Employe, EmployeDAO> implements EmployeManagerInterface {
}
