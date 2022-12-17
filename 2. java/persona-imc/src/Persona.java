



public class Persona {

    // Atributos
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;


    // Constructores
    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }



    // Metodo para calcular el IMC  de una persona
    int cacularIMC() {

        double imc = 0;
        try {
            imc = peso / Math.pow(altura,2);
        } catch (Exception e) {
            System.out.println("error calculando el IMC" + e.getMessage());
        }


       int valor = 0;

        if (imc < 20) {
            valor = -1;
        } else if (imc > 20 && imc <= 25) {
            valor = 0;
        } else {
            valor = 1;
        }

        return valor;


    }

   // Metodo para saber si una persona es mayor de edad
    boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre = '" + nombre + '\'' +
                ", edad = " + edad +
                ", dni = '" + dni + '\'' +
                ", peso = " + peso +
                ", altura = " + altura +
                '}';
    }
}
