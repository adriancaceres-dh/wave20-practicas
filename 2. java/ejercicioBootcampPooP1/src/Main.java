public class Main {
    public static void main(String[] args) {
        Persona personaSola = new Persona();
        Persona personaNombre = new Persona("Diana", 26, "1018400300");
        Persona personaCompleta = new Persona("Diana", 26, "1018788900", 56.9, 1.60);
        System.out.println(personaCompleta.calcularIMC());
        System.out.println(personaCompleta.esMayorDeEdad());
        System.out.println(personaCompleta.toString());
        System.out.println(personaCompleta.calcularImc2());
    }
}