package AgenciaDeTurismo;

import java.util.LinkedList;
import java.util.List;

public class Agencia {
    List<Cliente> clientes;
    List<Localizador> localizadores;

    public Agencia() {
        clientes = new LinkedList<>();
        localizadores = new LinkedList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void nuevoClient(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
}
