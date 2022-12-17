public class Main {


    // Lectura de imc de persona
    static void lecturaImc (int imc) {

        if (imc == -1){
            System.out.println("Su peso se encuentra por debajo de 20, tienes peso bajo");
        }else if (imc == 0){
            System.out.println("Su peso se encuentra entre 20 y 25, tu peso es saludable");
        } else if (imc == 1){
            System.out.println("Su peso es mayor de 25, tienes sobrepeso");
        }

    }

    public static void main(String[] args) {


        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jose", 30, "456789" );
        Persona persona3 = new Persona("Andrea", 21, "123789", 63, 1.65);




        lecturaImc(persona3.cacularIMC());
        System.out.println(persona3.esMayorDeEdad() ? "Eres Mayor de edad" : "No eres mayor de edad");
        System.out.println(persona3.toString());



    }
}
