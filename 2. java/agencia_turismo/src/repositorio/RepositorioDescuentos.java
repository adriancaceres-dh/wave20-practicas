package repositorio;

import agencia.descuento.Descuento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDescuentos {
    private static final List<Descuento> descuentos = new ArrayList<>();

    public static void addDescuento(Descuento descuento) {
        descuentos.add(descuento);
    }

    public static List<Descuento> listDescuentos() {
        return descuentos;
    }

    public static List<Descuento> listDescuentosVigentes() {
        return descuentos.stream()
                .filter(Descuento::estaVigente)
                .collect(Collectors.toList());
    }

}
