public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Ivan", 21, "11111111");
        Persona persona3 = new Persona("Tobias", 21, "22222222", 80, 1.80);

        int imc = persona3.calcularIMC();
        boolean mayorDeEdad = persona3.esMayorDeEdad();

        if(imc == -1){
            System.out.print("Imc por debajo de 20 - Bajo peso");
        }else {
            if (imc == 0) {
                System.out.print("Imc mayor o igual a 20 y menor o igual a 25 - Peso saludable");
            } else {
                System.out.print("Imc mayor a 25 - Sobrepeso");
            }
        }

        System.out.println();
        if(mayorDeEdad){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }

        System.out.println();
        System.out.println(persona3.toString());
    }
}