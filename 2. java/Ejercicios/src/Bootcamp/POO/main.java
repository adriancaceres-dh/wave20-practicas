package Bootcamp.POO;

public class main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 20, "12342");
        Persona persona3 = new Persona("Carlos", 21, "43232", 65, 1.78 );
        Persona persona4 = new Persona("Jessica", 21, null);

        System.out.println("Informacion de interes: " + persona3.toString());
        System.out.println("Mayor de edad: " + persona3.esMayorDeEdad());
        System.out.println("De acuerdo al IMC, tiene: " + persona3.calcularIMC());
    }
}
