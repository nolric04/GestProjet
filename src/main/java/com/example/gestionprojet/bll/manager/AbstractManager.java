package com.example.gestionprojet.bll.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class AbstractManager <T, R extends CrudRepository<T, Long>> implements ManagerGenericInterface {

    @Autowired
    protected R repo;

    @Override
    public List<T> getAll() {
        return (List<T>) repo.findAll();
    }

    @Override
    public Object getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void addOne(Object objet) {
        repo.save((T)objet);
    }

    @Override
    public void delete(Object objet) {
        repo.delete((T) objet);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Object objet) {
        repo.save((T)objet);
    }
}
