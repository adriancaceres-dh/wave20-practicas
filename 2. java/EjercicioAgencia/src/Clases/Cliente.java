package Clases;

import java.util.Objects;

public class Cliente {
    private String nombre;
    private long dni;

    public Cliente(String nombre, long dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdCliente() {
        return dni;
    }

    public void setIdCliente(long dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return dni == cliente.dni && Objects.equals(getNombre(), cliente.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), dni);
    }
}
