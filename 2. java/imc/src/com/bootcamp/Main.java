package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        Persona anonimo = new Persona();
        Persona fatima = new Persona("Fatima", 24, "FATIMA-123");
        Persona luis = new Persona("Luis", 25, "LUIS-123", 75, 1.83);

        // Persona alex = new Persona("Alex", 24); -- No se puede instanciar

        // Mostrar mensaje IMC
        System.out.println(mostrarIMC(luis));
        // Mostrar mensaje mayoría de edad
        System.out.println(mostrarMayoriaDeEdad(luis));
        // Mostrar información de la persona
        System.out.println(luis);
    }

    public static String mostrarIMC(Persona persona) {
        String mensaje = "El nivel de peso para " + persona.nombre + " es el siguiente: ";
        switch (persona.calcularIMC()) {
            case -1:
                mensaje += "Bajo peso";
                break;
            case 0:
                mensaje += "Peso saludable";
                break;
            case 1:
                mensaje += "Sobre peso";
                break;
            default:
                mensaje += "N/A";
                break;
        }

        return mensaje;
    }

    public static String mostrarMayoriaDeEdad(Persona persona) {
        String mensaje = persona.nombre + " es ";
        return persona.esMayorDeEdad() ? mensaje + "mayor de edad" : mensaje + "menor de edad";
    }
}
