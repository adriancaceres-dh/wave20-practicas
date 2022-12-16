public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("persona2", 18,"persona2Dni");
        Persona persona3 = new Persona("persona3", 12,"persona2Dni",35.5,1.46);
        System.out.println(persona3.calcularIMC());
        System.out.println(persona3.esMayorDeEdad());
        System.out.println(persona3.toString());
    }
}
        