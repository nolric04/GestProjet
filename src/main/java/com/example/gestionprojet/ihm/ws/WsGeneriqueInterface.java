package com.example.gestionprojet.ihm.ws;

import com.example.gestionprojet.bo.Entreprise;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface WsGeneriqueInterface<T> {
    @PostMapping("/add")
    public String add(@RequestBody T e);

    @GetMapping("/getall")
    public List<T> getAll();

    @GetMapping("/get/{id}")
    public T getOne(@PathVariable("id") Long id);

    @DeleteMapping("/delete/{id}")
    public String deleteOne(@PathVariable("id") Long id);
}
