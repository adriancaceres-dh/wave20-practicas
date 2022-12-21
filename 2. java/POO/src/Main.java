import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Emanuel", 22, "5.190.755-2");
        Persona persona3 = new Persona("Emanuel", 22, "5.190.755-2", 86.2, 1.79);
        // Persona persona4 = new Persona("Emanuel",22); No hay constructor que pueda crearlo.

        int imcPersona3 = persona3.calcularIMC();
        System.out.print("La persona: " + persona3.toString() + " posee un IMC de: " + imcPersona3 + ". \nEsto " +
                "significa que la persona posee un nivel de peso: ");
        switch (imcPersona3){
            case -1:
                System.out.println("Bajo peso");
                break;

            case 0:
                System.out.println("Peso saludable");
                break;

            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                System.out.println("Error");
        }

        boolean esMayor = persona3.esMayorDeEdad();
        System.out.print("\nAdemás, esta persona posee la edad de: " + persona3.getEdad() + " años. " +"Es decir, esta persona ");
        if(esMayor){
            System.out.println("es mayor de edad.");
        }else{
            System.out.println("no es mayor de edad.");
        }
    }
}