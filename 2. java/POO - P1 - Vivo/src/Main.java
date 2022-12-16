public class Main {
    public static void main(String[] args) {


        Persona personaA = new Persona();
        Persona personaB = new Persona("Eliana Fernandez", (short)2, "93531351");
        Persona personaC = new Persona("Pablo Lopez", (short)56, "43551357", 76.4, 1.76);


        if (personaC.esMayorDeEdad()){
            System.out.print("\n" + personaC.nombre + " es mayor de edad y ");
        } else {
            System.out.print("\n" + personaC.nombre +  " es menor de edad y ");
        }

        if (personaC.calcularIMC() == -1){
            System.out.print(" tiene bajo peso.\n");
        } else if (personaC.calcularIMC() == 0){
            System.out.print("tiene un peso saludable.\n");
        } else System.out.print(" tiene sobrepeso.\n");

        System.out.println(personaC.toString());

    }
}