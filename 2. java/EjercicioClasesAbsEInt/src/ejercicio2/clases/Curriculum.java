package ejercicio2.clases;

import ejercicio2.interfaces.Imprimible;

public class Curriculum implements Imprimible {
    String nombre;
    String apellido;
    String profesion;

    public Curriculum(String nombre, String apellido, String profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }

    public void imprimir(){
        System.out.println("Impresion de Curriculum: " + nombre + " | " + apellido + " | " + profesion);
    }
}
