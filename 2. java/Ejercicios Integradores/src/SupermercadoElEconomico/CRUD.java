package SupermercadoElEconomico;

import java.util.List;
import java.util.Optional;

public interface CRUD <T>{
    boolean alta(T cliente);
    boolean baja(Integer id);
    Optional<T> buscar(Integer dni);

    void mostrarEnPantalla(T cliente);
    List<T> traerTdos(T cliente);
}
