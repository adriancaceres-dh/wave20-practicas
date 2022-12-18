public class Main {
    public static void main(String[] args) {
        Persona personaUno = new Persona();

        Persona personaDos = new Persona("Pepe", 33, 30000000);

        Persona personaTres = new Persona("Marta", 40, 25000000, 60.500, 1.65);

      //  Persona personaCuatro = new Persona ("Francisco", 27);

        System.out.println(personaTres.toString());

        if(personaTres.esMayorDeEdad())
        {
            System.out.println("La persona es mayor de edad.");
        }else{
            System.out.println("La persona no es mayor de edad.");
        }

        switch(personaTres.calcularIMC())
        {
            case -1:
                System.out.println("La persona posee un bajo peso.");
                break;
            case 0:
                System.out.println("La persona posee un peso saludable.");
                break;
            case 1:
                System.out.println("La persona posee sobrepeso.");
                break;
            default:
                System.out.println("Error.");
                break;
        }
    }
}