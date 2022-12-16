package objetos;

public class Main {
        public static void main(String[] args) {
            Persona persona1 = new Persona();
            Persona persona2 = new Persona("Tammara","26","123456");
            Persona persona3 = new Persona("Romina","45","34567",60,1.67);

            int calculoIMC = persona3.calcularIMC();
            boolean esMayor = persona3.esMayorDeEdad();
            String infoPersona = persona3.toString();
            System.out.println(infoPersona);
            switch (calculoIMC){
                case -1:
                    System.out.println("Bajo Peso");
                    break;
                case 0:
                    System.out.println("Peso saludable");
                    break;
                case 1:
                    System.out.println("Sobrepeso");
                    break;
            }
            //No es posible construir una persona con nombre y edad porque no hay un constructor que tenga solo esos dos parametros

        }
}
