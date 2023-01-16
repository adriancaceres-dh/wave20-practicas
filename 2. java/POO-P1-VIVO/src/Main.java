public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan",21,"123456789");
        Persona persona3 = new Persona("Sebastian",22,"56437826572",90.0,1.90);

        String mayorDeEdad = persona3.esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad";
        System.out.println(mayorDeEdad);
        String imc = "";
        if(persona3.calcularIMC() == -1){
            imc = "Bajo pesp";
        } else if(persona3.calcularIMC() == 0){
            imc = "Peso saludable";
        } else {
            imc = "Sobrepeso";
        }
        System.out.println(imc);
        System.out.println();
        System.out.println(persona3);
    }
}
