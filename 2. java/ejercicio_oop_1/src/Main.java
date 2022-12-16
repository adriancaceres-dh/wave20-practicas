public class Main {
    public static void main(String[] args) {

        Persona persona_sin_parametros = new Persona();
        Persona luciano = new Persona("luciano", 26, "39891852");
        Persona luciano_completo = new Persona("luciano", 26, "39891852",
                50, 1.65);
        //Persona test = new Persona("nombre", "24"); --> no funciona
        System.out.println(luciano_completo.calcularIMC());
        System.out.println(luciano_completo.esMayorDeEdad());
        System.out.println(luciano_completo.toString());
    }
}