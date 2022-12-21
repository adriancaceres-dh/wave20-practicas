package repositorios;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class DAO<T> {
    private final List<T> entidades;

    public DAO(List<T> entidades) {
        this.entidades = entidades;
    }

    public Optional<T> buscar(Predicate<T> predicate) {
        return entidades.stream()
                .filter(predicate)
                .findFirst();
    }

    public List<T> buscarTodos() {
        return entidades;
    }

    public void remove(int index) {
        entidades.remove(index);
    }

    public void remove(T entidad) {
        entidades.remove(entidad);
    }

    public void get(int index) {
        entidades.get(index);
    }

    public boolean contains(T entidad) {
        return entidades.contains(entidad);
    }

    public void add(T entidad) {
        entidades.add(entidad);
    }
}
