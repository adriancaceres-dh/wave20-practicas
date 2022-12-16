public class Persona {
    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;
    public Persona(){

    }
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni, float peso, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = (peso/(Math.pow(altura,2)));
        int resultado = imc < 20 ? -1 : imc >= 20 && imc <= 25 ? 0 : 1;
        return resultado;
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    public String toString(){
        return "Nombre: " + nombre + ", edad: " + edad + ", dni: " + dni + ", peso: " + peso + ", altura: " + altura;
    }

}
