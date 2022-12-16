package ejemplo;

public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaNoTanVacia = new Persona("John Doe", 32, "123345678");
        Persona personaConPesoAltura = new Persona("Juan Pérez", 24, "1231231321", 1.8f, 73f);

        System.out.println("IMC: " + personaConPesoAltura.calcularIMC());
        System.out.println(personaConPesoAltura.getNombre() + " es mayor de edad?: " + personaConPesoAltura.esMayorDeEdad());
        System.out.println("Datos de la persona\n" + personaConPesoAltura);
    }
}