public class Persona {

    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        try {
            float imc = (float) (peso / Math.pow(altura, 2));
            if (imc < 20) {
                return -1;
            } else if (imc <= 25) {
                return 0;
            } else {
                return 1;
            }
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Error en el cáclulo: " + e.getMessage());
        }catch (Exception e){
            throw new IllegalArgumentException("Error: " + e.getMessage());
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
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
