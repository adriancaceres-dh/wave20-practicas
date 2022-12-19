public class Persona {

    String nombre;
    int edad;
    String dni;
    int peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public static int calcularIMC(int peso, double altura){
        double imc = peso/Math.pow(altura,2);
        if(imc < 20) {
            return -1;
        }else{
            if(imc <= 25) {
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static boolean esMayorDeEdad(int edad){
        if(edad > 18) {
            return true;
        }else{
            return false;
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
}
