package com.example.gestionprojet.ihm.ws.projet;

import com.example.gestionprojet.bll.manager.projet.ProjetManager;
import com.example.gestionprojet.bo.Projet;
import com.example.gestionprojet.ihm.ws.AbstractWsGeneric;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws/projet")
public class WsProjet extends AbstractWsGeneric<Projet, ProjetManager> implements WsProjetInterface{
}
