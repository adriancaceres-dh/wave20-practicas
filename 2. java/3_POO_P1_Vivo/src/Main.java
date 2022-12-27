public class Main {
    public static void main(String[] args) {

        Persona personaAndres = new Persona();
        Persona personaJennifer = new Persona("Jennifer Mino", 34 , "1130540");
        Persona personaLiam = new Persona("Liam Gutierrez", 8, "1117450", 30.5, 1.25);
        Persona personaManuel = new Persona("Manuel Diaz", 36, "1130607", 81, 1.80);

        System.out.println(personaManuel.calcularIMC());
        /*System.out.println(personaJennifer.calcularIMC());
        System.out.println(personaLiam.calcularIMC());*/

        System.out.println(personaManuel.esMayorDeEdad());
       /* System.out.println(personaJennifer.esMayorDeEdad());
        System.out.println(personaLiam.esMayorDeEdad());*/

        System.out.println(personaManuel.toString());

        double imcPersona = personaManuel.calcularIMC();

        if(imcPersona < 0) System.out.println("La persona con nombre " + personaManuel.getNombre() + " esta bajo de peso.");
        if(imcPersona == 0) System.out.println("La persona con nombre " + personaManuel.getNombre() + " tiene un peso saludable.");
        if(imcPersona > 0) System.out.println("La persona con nombre " + personaManuel.getNombre() + " tiene sobrepeso.");


    }
}