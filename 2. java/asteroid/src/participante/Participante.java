package participante;

import nave.Nave;

import java.awt.*;

public class Participante {
    private String nombre;
    private Nave nave;
    private int puntaje;

    public Participante(String nombre, Nave nave) {
        this.nombre = nombre;
        this.nave = nave;
        puntaje = 0;
    }

    public double calcularDistancia(Point punto) {
        return nave.calcularDistancia(punto);
    }

    public void sumarPunto() {
        puntaje++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
