public class Main {
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona personaSinPesoNiAltura = new Persona("Carlos", 15, "35234452");
        Persona personaCompleta = new Persona("Laura", 45, "462342422", 50, 1.80);

        personaCompleta.esMayorDeEdad();
        personaCompleta.calcularIMC();
        System.out.println(personaCompleta);
    }
}