public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Pedro",15,"45886987");
        Persona p3 = new Persona("Juan",25,"89766543",87.9,1.8);

        System.out.println(p3.esMayorDeEdad());
        System.out.println(p3.cacularIMC());
    }
}