import modelo.Persona;

public class Main {
    public static void main(String[] args) {

        Persona per1 = new Persona("Javiera",28,"18.232.656-8", 71, 1.70);
        //String nombre, int edad, String DNI, int peso, int altura
        System.out.println((per1.esMayorDeEdad())?"La persona es mayor de edad":"La persona no es mayor de edad");
        switch (per1.calculaIMC()) {
            case -1:
                System.out.println("Bajo Peso");
                break;
            case 0:
                System.out.println("Peso ideal");
                break;
            case 1 :
                System.out.println("Sobre peso");
                break;
            default:
                System.out.println("Error");
        }
    }
}