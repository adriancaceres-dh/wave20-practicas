import java.util.ArrayList;
import java.util.List;

public class Equipo {
    List<Jugador> jugadores;
    String pais;

    public Equipo(String pais) {
        this.pais = pais;
        jugadores = new ArrayList<>();
    }
}
