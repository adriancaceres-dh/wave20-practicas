package Bootcamp.POO.POO1.Ejercicio1;

public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
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

    public int calcularIMC(){
        double calculo =  (peso/(Math.pow(altura, 2)));
        if(calculo <20){
            return -1;
        }else if(calculo<=25){
            return 0;
        }else{
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        return edad >=18;
    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
