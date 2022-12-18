public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jhon","1007414252",22);
        Persona persona3 = new Persona("Tomas","42328178392",20,80.0,1.83);

        System.out.println(persona3);

        System.out.print("Mayor de edad: ");
        if(persona3.esMyorDeEdad()){
            System.out.println("Si");
        } else {
            System.out.println("No");
        }

        System.out.print("Nivel de peso: ");
        switch (persona3.calcularIMC()){
            case -1:
                System.out.println("Bajo Peso");
                break;
            case 0:
                System.out.println("Peso daludable");
                break;
            case 1:
                System.out.println("Peso peso bajo");
                break;
        }


    }
}
