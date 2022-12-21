package Bootcamp.IntegradorP1.Crud;

import java.util.List;
import java.util.Optional;

public interface Crud <T> {

    public void guardar(T objeto);
    public void mostrar();
    public Optional<T> buscar (Integer id);
    public void eliminar(Integer id);
    public List<T> traer();

}
