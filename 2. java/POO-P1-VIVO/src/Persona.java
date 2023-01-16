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

    public int calcularIMC(){
        double imc = peso/(Math.pow(altura,2));
        if(imc < 20){
            return -1;
        }else if(imc >= 20 && imc <= 25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18 ? true : false;
    }

    @Override
    public String toString() {
        String mayorDeEdad = esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad";
        String imc = "";
        if(calcularIMC() == -1){
            imc = "Bajo pesp";
        } else if(calcularIMC() == 0){
            imc = "Peso saludable";
        } else {
            imc = "Sobrepeso";
        }

        return "Persona { " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", " + mayorDeEdad +
                ", " + imc + " " +
                '}';
    }
}
