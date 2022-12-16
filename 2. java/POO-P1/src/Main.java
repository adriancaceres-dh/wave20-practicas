public class Main {
    public static void main(String[] args) {

        Persona personaVacio = new Persona();

        Persona personaBase = new Persona("Pepe", 23, "1111111");

        Persona personaCompleto = new Persona("Pepito", 24, "2222222", 70.6,1.75);

        //Persona personaSinDni = new Persona("Pepo", 25);
        //No se puede, en el caso de querer hacer esto necesitaría un nuevo constructor sin dni

        //Averiguo el IMC y devuelvo un mensaje acorde:
        switch ((int) personaCompleto.calcularIMC()){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        System.out.println("IMC= " + personaCompleto.calcularIMC());

        //Averiguo la edad de la persona:
        if(personaCompleto.esMayorDeEdad()) System.out.println("La persona es mayor de edad");
        else System.out.println("La persona no es mayor de edad");

        //Doy todos los datos de la persona:
        System.out.println(personaCompleto.toString());

    }
}