package com.example.gestionprojet.ihm.ws;

import com.example.gestionprojet.bo.Entreprise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface WsGeneriqueInterface<T> {

    String add(@RequestBody T e);
    List<T> getAll();
    T getOne(@PathVariable("id") Long id);
    String deleteOne(@PathVariable("id") Long id);
}
