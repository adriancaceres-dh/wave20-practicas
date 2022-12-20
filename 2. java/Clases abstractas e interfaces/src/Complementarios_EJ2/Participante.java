package Complementarios_EJ2;

import java.util.LinkedList;

public class Participante {
    private int id;

    private String nombre;
    private String apellido;

    private LinkedList<Nave> navesJugador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LinkedList<Nave> getNavesJugador() {
        return navesJugador;
    }

    public void agregarNaveJugador(Nave nuevaNave) {
        navesJugador.add(nuevaNave);
    }

    public Participante(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
