import Entidad.Persona;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        //No es posible sin un contructor sin DNI
        Persona persona1 = new Persona("Juan", 30, "111111");
        Persona persona2 = new Persona("Maria",41,"21222",58,1.60);
        System.out.println(persona2.toString());
        switch (persona2.calcularMC()){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobre peso");
                break;
        }
        System.out.println("Es mayor de edad: "+persona2.esMayorDeEdad());



    }
}