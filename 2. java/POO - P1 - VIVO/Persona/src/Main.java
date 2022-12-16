public class Main {
    public static void main(String[] args) {
        Persona juan = new Persona();
        Persona luis = new Persona("Luis",35, "1478569-8");
        Persona pepe = new Persona("Pepe",18, "2547896-2", 70.0f, 1.8f);

        int imc = pepe.calcularIMC();
        if (imc == -1){
            System.out.println("La persona está bajo peso.");
        }else if (imc == 0){
            System.out.println("La persona tiene un peso saludable.");
        }else{
            System.out.println("La persona está sobre peso.");
        }

        boolean esMayor = pepe.esMayorDeEdad();
        if (esMayor) {
            System.out.println("La persona es mayor de edad.");
        }else{
            System.out.println("La persona es menor de edad.");
        }

        System.out.println(pepe);
    }
}