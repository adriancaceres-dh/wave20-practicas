package Ejercicio3;

public class Gato extends Animal implements ICarnivoro {
    String nombre;

    public Gato(String nombre) {
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
        System.out.println("MIAAUUUU");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }
}
