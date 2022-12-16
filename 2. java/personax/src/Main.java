public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Raúl", 25, "12123345");
        Persona persona3 = new Persona("José", 22, "34345345", 70.0f, 1.80f);

        int imc = persona3.calcularIMC();

        if(imc == -1){
            System.out.println("Bajo peso");
        } else if (imc == 0) {
            System.out.println("Peso saludable");
        }else System.out.println("Sobrepeso");

        boolean esMayor = persona3.esMayorDeEdad();

        if(esMayor) System.out.println("Es mayor");
        else System.out.println("Es menor");

        System.out.println(persona3.toString());
    }
}