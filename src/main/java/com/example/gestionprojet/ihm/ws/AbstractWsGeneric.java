package com.example.gestionprojet.ihm.ws;

import com.example.gestionprojet.bll.manager.ManagerGeneriqueInterface;
import com.example.gestionprojet.ihm.ws.WsGeneriqueInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AbstractWsGeneric <T, R extends ManagerGeneriqueInterface<T>> implements WsGeneriqueInterface<T> {

    @Autowired
    R manager;

    @PostMapping("/add")
    public String add(@RequestBody T e){
        manager.add(e);
        return "ajout effectué";
    }

    @GetMapping("/getall")
    public List<T> getAll(){
        return manager.getAll();
    }

    @GetMapping("/get/{id}")
    public T getOne(@PathVariable("id") Long id){
        return manager.getById(1L);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOne(@PathVariable("id") Long id){
        try{
            manager.delete(id);
            return "suppression effectuée";
        }catch(Exception e){
            return "La suppression n'a pu être effectuée";
        }
    }
}
