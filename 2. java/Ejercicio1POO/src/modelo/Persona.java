package modelo;

public class Persona {
    String nombre;
    int edad;
    String DNI;
    int peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public Persona(String nombre, int edad, String DNI, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public boolean esMayorDeEdad(){
        if(this.edad>18){
            return true;
        }else{
            return false;
        }
    }
    public int calculaIMC(){
        double imc = (this.peso/(Math.pow(this.altura,2)));
        if (imc<20){
            return -1;
        } else if (imc>=20 && imc <=25) {
            return 0;
        }else if(imc>25){
            return 1;
        }
        return -2;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
