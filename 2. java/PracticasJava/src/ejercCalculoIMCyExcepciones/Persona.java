package ejercCalculoIMCyExcepciones;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

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

    public static int calcularIMC(Persona persona){
       double imc = persona.getPeso()/ Math.pow(persona.getAltura(),2);
        if(imc < 20){
            return -1;
        } else if (imc>= 20 && imc<=25) {
            return 0;
        }else{
            return 1;
        }
    }
    public static boolean esMayorDeEdad(Persona persona){
        if(persona.getEdad() < 18){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }


    public int getEdad() {
        return edad;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }



    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("juan", 21,"2323232323");
        Persona persona3 = new Persona("juan", 16,"2323232323", 80.0,1.76);

        int imc = Persona.calcularIMC(persona3);
        System.out.println("El indice de masa corporal es de: " + imc);
        switch (imc){
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

        boolean esMayorEdad = Persona.esMayorDeEdad(persona3);
        if(esMayorEdad == true){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("la persona es menor de edad");
        }
        System.out.println("Datos de la Persona: ");
        System.out.println(persona3.toString());
    }
}
