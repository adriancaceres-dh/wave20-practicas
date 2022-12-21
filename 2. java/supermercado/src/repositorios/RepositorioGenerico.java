package repositorios;

import java.util.List;

public class RepositorioGenerico<T> {
    protected DAO<T> dao;

    protected RepositorioGenerico(DAO<T> dao) {
        this.dao = dao;
    }

    public List<T> buscarTodos() {
        return dao.buscarTodos();
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

    public boolean contains(T entidad) {
        return dao.contains(entidad);
    }

    public void add(T entidad) {
        dao.add(entidad);
    }
}
