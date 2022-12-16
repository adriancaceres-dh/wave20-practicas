package Bootcamp;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso/(Math.pow(altura,2));
        int salida;
        if(imc < 20) salida = -1;
        else if (imc <= 25) salida = 0;
        else salida = 1;
        return salida;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        return "Nombre: " + nombre
                + "\nEdad: " + edad
                + "\nDNI: " + dni
                + "\nPeso: " + peso
                + "\nAltura: " + altura;
    }


}
