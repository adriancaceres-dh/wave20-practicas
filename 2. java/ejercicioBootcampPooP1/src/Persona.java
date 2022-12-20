import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.ArrayList;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;
    public Persona(){

    }
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre =  nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    public int calcularIMC() {
        double imc = this.peso / (2 * this.altura);
        if (imc < 18) {
            return -1;
        }
        else if (imc >= 18 && imc <= 25) {
            return 0;
        }
        return 1;
    }
    public String calcularImc2() {
        double imc = this.peso / (2 * this.altura);
        if (imc < 18) {
            return "Tu indice de masa corporal es: Bajo Peso, ¡¡¡¡ Debes ir por un chequeo !!!! ";
        }
        else if (imc >= 18 && imc <= 25) {
            return "Tu indice de masa corporal es: Bajo Saludable, ¡¡¡¡ Tu estas muy saludable !!!!";
        }
        return "Tu indice de masa corporal es: Sobrepeso, ¡¡¡ No te preocupes, mucho ejercicio y buena alimentación";
    }
    public boolean esMayorDeEdad(){
        int calcularEdad = this.edad;
        if(calcularEdad>=18){
            return true;
        }
        return false;
    }
    public String toString(){
        return "Nombre: " + this.nombre + "," + " Edad: " + this.edad + "," +
                " DNI: " + this.dni + "," + " Peso: " + this.peso + "," +
                " Altura: " + this.altura;
    }
}

