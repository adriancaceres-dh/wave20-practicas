package ejemplo;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float altura;
    private float peso;

    public Persona(String nombre, int edad, String dni, float altura, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public int calcularIMC(){
        double imc = peso / Math.pow(altura, 2);
        if (imc < 20){
            return -1;
        }
        if (imc <= 25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
