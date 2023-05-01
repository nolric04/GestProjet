package com.example.gestionprojet.ihm.ws.employe;

import com.example.gestionprojet.bll.manager.employe.EmployeManager;
import com.example.gestionprojet.bo.Employe;
import com.example.gestionprojet.ihm.ws.AbstractWsGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/employe")
public class WsEmploye extends AbstractWsGeneric<Employe, EmployeManager> implements WsEmployeInterface{
}
