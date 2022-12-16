public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Lionel", 35,"33456798");

        Persona persona3 = new Persona("Dibu", "34654987", 33, 80.0,1.8);

        System.out.println("IMC:");
        if(persona3.calcularIMC() == -1){
            System.out.println("Bajo peso");
        }
        if (persona3.calcularIMC() == 0) {
            System.out.println("Peso saludable");
        }
        if(persona3.calcularIMC() == 1) {
            System.out.println("Sobrepeso");
        }

        System.out.println("Edad:");
        if(persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }

        System.out.println(persona3.toString());


    }
}