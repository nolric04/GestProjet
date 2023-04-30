package com.example.gestionprojet.ihm.ws;

import com.example.gestionprojet.bll.manager.entreprise.EntrepriseManagerInterface;
import com.example.gestionprojet.bo.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ws/entreprise")
public class WsEntreprise {

    @Autowired
    EntrepriseManagerInterface entrepriseManager;

    @PostMapping("/add")
    public void newEntreprise(Entreprise e){
        entrepriseManager.add(e);
    }

    @GetMapping("/getall")
    public List<Entreprise> getAllEntreprise(){
        return entrepriseManager.getAll();
    }

    @GetMapping("/get/{id}")
    public void getOneEntreprise(long id){
        entrepriseManager.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOneEntreprise(Long id){
        entrepriseManager.delete(id);
    }
}
