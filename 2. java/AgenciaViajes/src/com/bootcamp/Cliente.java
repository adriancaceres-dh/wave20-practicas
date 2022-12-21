package com.bootcamp;

import java.util.List;

public class Cliente {
    private String nombre;
    private String id;

    public Cliente(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param lista
     * @return la cantidad de localizadores adquiridos por el cliente anteriormente
     */
    public int verificarReservasAnteriores(List<Localizador> lista) {
        return (int) lista.stream().filter(l -> l.getCliente().getId().equals(this.id)).count();
    }
}
