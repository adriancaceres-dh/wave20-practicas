package Ejercicio1;

import java.util.LinkedList;

public class Banco {
    private LinkedList<Usuarios> usuariosBanco = new LinkedList<>();

    private String nombreBanco;

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public LinkedList<Usuarios> getUsuariosBanco() {
        return usuariosBanco;
    }

    public void agregarUsuariosBanco(Usuarios nuevoUsuario) {
        usuariosBanco.add(nuevoUsuario);
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
}
