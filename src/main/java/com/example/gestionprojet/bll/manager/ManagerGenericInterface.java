package com.example.gestionprojet.bll.manager;

import java.util.List;

public interface ManagerGenericInterface<T> {
    List<T> getAll();
    T getById(Long id);
    void addOne(T objet);
    void delete(T objet);
    void delete(Long id);
    void update(T objet);
}
