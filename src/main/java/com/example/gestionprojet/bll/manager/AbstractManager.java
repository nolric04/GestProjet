package com.example.gestionprojet.bll.manager;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractManager <T, R extends CrudRepository<T, Long>> implements ManagerGeneriqueInterface<T> {

    @Autowired
    protected R repo;

    @Override
    public List<T> getAll() {
        return (List<T>) repo.findAll();
    }

    @Override
    public T getById(Long id) {
        return (T) repo.findById(id);
    }

    @Override
    public void addOne(T objet) {
        repo.save((T)objet);
    }

    @Override
    @Transactional
    public void add(T... objet) {
        repo.saveAll(Arrays.asList(objet));
    }

    @Override
    public void delete(T objet) {
        repo.delete((T) objet);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(T objet) {
        repo.save((T)objet);
    }
}
