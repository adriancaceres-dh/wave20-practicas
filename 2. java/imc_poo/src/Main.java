public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Fran", 32, "17727519-0");
        Persona persona3 = new Persona("Fran", 32, "17727519-0", 72, 1.74);

        int imc = Persona.calcularIMC(persona3.peso, persona3.altura);
        System.out.println(persona3.toString());

        if(imc == -1) {
            System.out.println(persona3.nombre + " tiene Bajo Peso");
        }else{
            if(imc == 0) {
                System.out.println(persona3.nombre + " tiene un Peso Saludable");
            }else{
                System.out.println(persona3.nombre + " tiene Sobrepeso");
            }
        }

        if(Persona.esMayorDeEdad(persona3.edad)) {
            System.out.println(persona3.nombre + " es mayor de edad");
        }else{
            System.out.println(persona3.nombre + " es un bodoque");
        }



    }
}