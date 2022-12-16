package Entidad;

public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private float peso;
    private double altura;

    public Persona(String nombre, int edad, String DNI, float peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(){}

    public Persona(String nombre, int edad, String DNI) {
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public int calcularMC(){
        double CM = (peso/Math.pow(altura,2));
        if(CM<20){
            return -1;
        } else if (CM >20 && CM <=25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        return edad>18;
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
