package Ejercicio3;

public class Vaca extends Animal implements herbivoro{
    String nombre;

    public Vaca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void emitirSonidos() {
        System.out.println("MUUUUUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba...");
    }
}
