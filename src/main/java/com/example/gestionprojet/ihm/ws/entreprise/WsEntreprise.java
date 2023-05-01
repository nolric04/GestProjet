package com.example.gestionprojet.ihm.ws.entreprise;

import com.example.gestionprojet.bll.manager.entreprise.EntrepriseManagerInterface;
import com.example.gestionprojet.bo.Entreprise;
import com.example.gestionprojet.ihm.ws.AbstractWsGeneric;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ws/entreprise")
public class WsEntreprise extends AbstractWsGeneric<Entreprise, EntrepriseManagerInterface> implements WsEntrepriseInterface{

//    @Autowired
//    EntrepriseManagerInterface entrepriseManager;
//
//    @PostMapping("/add")
//    public String newEntreprise(@RequestBody Entreprise e){
//        entrepriseManager.add(e);
//        return "ajout effectué";
//    }
//
//    @GetMapping("/getall")
//    public List<Entreprise> getAllEntreprise(){
//        return entrepriseManager.getAll();
//    }
//
//    @GetMapping("/get/{id}")
//    public Entreprise getOneEntreprise(@PathVariable("id") Long id){
//        return entrepriseManager.getById(1L);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteOneEntreprise(@PathVariable("id") Long id){
//        try{
//            entrepriseManager.delete(id);
//            return "suppression effectuée";
//        }catch(Exception e){
//            return "la suppression n'a pu être effectuée";
//        }
//    }
}
