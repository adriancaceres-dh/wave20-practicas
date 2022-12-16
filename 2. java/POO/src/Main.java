public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Emanuel", 22, "5.190.755-2");
        Persona persona3 = new Persona("Emanuel", 22, "5.190.755-2", 78.2, 79.3);
        // Persona persona4 = new Persona("Emanuel",22); No hay constructor que pueda crearlo.

        int imcPersona3 = persona3.calcularIMC();
        System.out.print("La persona: " + persona3.toString() + " posee un IMC de: " + imcPersona3 + ". Esto " +
                "significa que la persona posee un nivel de peso: ");
        if (imcPersona3 == -1) {
            System.out.print("Bajo peso");
        } else if (imcPersona3 == 0) {
            System.out.print("Peso saludable");
        } else {
            System.out.print("Sobrepeso");
        }
        System.out.println();

        boolean esMayor = persona3.esMayorDeEdad();
        System.out.print("Además, esta persona posee la edad de: " + persona3.getEdad() + " años. " +"Es decir, esta persona ");
        if(esMayor){
            System.out.print("es mayor de edad.");
        }else{
            System.out.print("no es mayor de edad.");
        }
    }
}