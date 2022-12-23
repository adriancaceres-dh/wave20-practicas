package com.bootcamp.covid.repository.factory;

import com.bootcamp.covid.repository.DAO;
import com.bootcamp.covid.repository.Repository;

import java.util.HashMap;

public class RepositoryFactory {
    private static final HashMap<String, Repository> repos = new HashMap<>();

    public static <T> Repository<T> get(Class<T> clazz) {
        Repository<T> repo;
        if (repos.containsKey(clazz.getName())) {
            repo = repos.get(clazz.getName());
        } else {
            repo = new Repository<>(new DAO<>());
            repos.put(clazz.getName(), repo);
        }
        return repo;
    }
}
