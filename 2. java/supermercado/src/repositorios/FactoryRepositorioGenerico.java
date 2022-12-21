package repositorios;

import repositorios.DAO;
import repositorios.RepositorioGenerico;

import java.util.ArrayList;
import java.util.HashMap;

public class FactoryRepositorioGenerico {
    private static final HashMap<String, RepositorioGenerico> repos = new HashMap<>();

    public static <T> RepositorioGenerico<T> get(Class<T> clazz) {
        RepositorioGenerico<T> repo;
        if (repos.containsKey(clazz.getName())) {
            repo = repos.get(clazz.getName());
        } else {
            repo = new RepositorioGenerico<>(new DAO<>(new ArrayList<>()));
            repos.put(clazz.getName(), repo);
        }
        return repo;
    }
}