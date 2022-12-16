public class Persona {
    String nombre;
    Integer edad;
    String dni;
    double peso;
    double altura;

    public Persona(String nombre, Integer edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona() {
    }

    public int calcularIMC(){
        double imc= peso / (altura * altura);
        if(imc >= 20 && imc <= 25){
             return 0;
        }
        else if(imc >25){
            return 1;
        }
        else {
            return -1;
        }
    }
    public boolean mayorDeEdad(){
        if(edad >= 18){
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
