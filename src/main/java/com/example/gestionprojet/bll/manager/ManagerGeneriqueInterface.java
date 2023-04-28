package com.example.gestionprojet.bll.manager;

import java.util.List;

public interface ManagerGeneriqueInterface<T> {
    List<T> getAll();
    T getById(Long id);
    void addOne(T objet);
    void add(T... objet);
    void delete(T objet);
    void delete(Long id);
    void update(T objet);
}
