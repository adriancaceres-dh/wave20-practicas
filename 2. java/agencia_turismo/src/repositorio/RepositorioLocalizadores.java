package repositorio;

import agencia.Localizador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
    private final static List<Localizador> localizadores = new ArrayList<>();

    public static void addLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public static List<Localizador> listLocalizadores() {
        return localizadores;
    }
}
