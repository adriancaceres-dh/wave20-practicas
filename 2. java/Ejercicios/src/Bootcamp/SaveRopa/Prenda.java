package Bootcamp.SaveRopa;

public class Prenda {
    protected String marca;
    protected String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s", marca, modelo);
    }
}