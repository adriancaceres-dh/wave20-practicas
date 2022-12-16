public class Persona {
    private String nombre, dni;
    private int edad, peso;
    private double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
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

    public int calcularIMC(){
        double imc = this.peso/(Math.pow(this.altura,2));
        if(imc < 20) return -1;
        if(imc >= 20 && imc <=25) return 0;
        else return 1;
    }

    public  boolean esMayorDeEdad(){
        if(this.edad < 18) return false;
        else return true;
    }
    public  String toString(){
        String persona_string = this.nombre + this.dni + Integer.toString(this.edad) +
                Integer.toString(this.peso) + String.valueOf(this.altura);
        return persona_string;
    }

}
