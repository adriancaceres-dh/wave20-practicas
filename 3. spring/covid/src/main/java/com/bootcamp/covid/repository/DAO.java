package com.bootcamp.covid.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DAO<T> {
    private final List<T> entities;

    public DAO() {
        entities = new ArrayList<>();
    }

    public Optional<T> find(Predicate<T> predicate) {
        return entities.stream()
                .filter(predicate)
                .findFirst();
    }

    public List<T> findAll(Predicate<T> predicate) {
        return entities.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public void remove(int index) {
        entities.remove(index);
    }

    public void remove(T entity) {
        entities.remove(entity);
    }

    public void get(int index) {
        entities.get(index);
    }

    public List<T> getAll() {
        return entities;
    }

    public boolean contains(T entity) {
        return entities.contains(entity);
    }

    public void add(T entity) {
        entities.add(entity);
    }
}
