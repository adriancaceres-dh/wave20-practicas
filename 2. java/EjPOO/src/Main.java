public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Persona persona1 = new Persona("Seba", 25, "84526145");
        Persona persona2 = new Persona("Igna", 23, "521561564", 80.0,1.80);
        Persona juli = new Persona();

        System.out.println("imc de la persona: "+ persona2.calcularIMC());
        System.out.println("es mayor? "+ persona2.mayorDeEdad());
        System.out.println("datos: "+ persona2.toString());

    }
}