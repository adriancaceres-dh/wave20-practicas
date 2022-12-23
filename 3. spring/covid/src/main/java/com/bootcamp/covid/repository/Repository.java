package com.bootcamp.covid.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Repository<T> {
    protected DAO<T> dao;

    public Repository(DAO<T> dao) {
        this.dao = dao;
    }

    public Optional<T> find(Predicate<T> predicate) {
        return dao.find(predicate);
    }

    public List<T> findAll(Predicate<T> predicate) {
        return dao.findAll(predicate);
    }

    public void remove(int index) {
        dao.remove(index);
    }

    public void remove(T entidad) {
        dao.remove(entidad);
    }

    public void get(int index) {
        dao.get(index);
    }

    public List<T> getAll() {
        return dao.getAll();
    }

    public boolean contains(T entidad) {
        return dao.contains(entidad);
    }

    public void add(T entidad) {
        dao.add(entidad);
    }
}
