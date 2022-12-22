public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("daniel",20,"1001202650",55,1.78);
        Persona persona3 = new Persona("dani",14,"123");

        System.out.println(persona2.toString());
        persona2.calcularIMC();
        persona2.esMayorDeEdad();
    }
}