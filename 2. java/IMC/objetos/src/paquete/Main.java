package paquete;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("julian",25,"1017");
        Persona persona3 = new Persona("julian",16,"3232",71,1.90);

        System.out.println(persona3.calculaIMC());
        System.out.println(persona3.esMayorDeEdad());
        System.out.println(persona3.toString());

    }
}
