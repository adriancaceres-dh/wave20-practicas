public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pepe", 16, "1234562");
        Persona persona3 = new Persona("Maria", 18, "897872183", 35.0, 1.65);

        Persona persona4 = new Persona("Juanito", 25, null);
        System.out.println("Persona1: " + persona1);
        System.out.println("Persona2: " + persona2);
        System.out.println("Persona3: " + persona3);
        System.out.println("ICM:" + persona3.calcularIMC(persona3.getPeso(), persona3.getAltura()));
        System.out.println("Es mayor de edad: " + persona3.esMayorDeEdad(persona3.getEdad()));

    }
}