
public class Main {


    public static void main(String[] args) {
        Persona persona0 = new Persona();
        Persona persona1 = new Persona("Daniela", 25, "123456" );
        Persona persona2 = new Persona("Fran", 30, "09876", 70, 1.80);

        //Persona persona4 = new Persona("Daniela", 25 );
        System.out.println(persona2.toString());
        System.out.println(persona2.calcularIMC());
        System.out.println(persona2.esMayorDeEdad());
    }
}