package Bootcamp;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Augusto", 23, "22222222");
        Persona persona3 = new Persona("Alberto",21,"222222",80.3f,1.8f);

        System.out.println("IMC de la persona: " + persona3.calcularIMC());
        System.out.println("Es mayor de edad: " + persona3.esMayorDeEdad());
        System.out.println("Datos de la persona:");
        System.out.println(persona3.toString());
    }
}