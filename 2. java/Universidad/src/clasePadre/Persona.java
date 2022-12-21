package clasePadre;

import interfaces.IInteresante;

public abstract class Persona implements IInteresante {
    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void enseñar() {
        System.out.println("Debe enseñar");
    }

    @Override
    public void colaborar() {
        System.out.println("Debe colaborar");
    }
}
