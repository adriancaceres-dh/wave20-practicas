package clases;

public class Persona {

    String nombre;
    String edad;
    String dni;
    String domicilio;
    String ultimoTrabajo;

    public Persona(String nombre, String edad, String dni, String domicilio, String ultimoTrabajo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.domicilio = domicilio;
        this.ultimoTrabajo = ultimoTrabajo;
    }

    @Override
    public String toString() {
        return "Persona:" +
                "Nombre='" + nombre + '\'' +
                ", Edad='" + edad + '\'' +
                ", Dni='" + dni + '\'' +
                ", Domicilio='" + domicilio + '\'' +
                ", Último Trabajo='" + ultimoTrabajo + '\'';
    }
}