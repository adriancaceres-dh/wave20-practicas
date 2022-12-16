public class Persona {

    String nombre;
    short edad;
    String dni;
    double peso;
    double altura;

    public Persona () {

    }

    public Persona(String nombre, short edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, short edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC () {
        double imc = this.peso/(this.altura*this.altura);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } return 1;
    }

    public boolean esMayorDeEdad () {
        return (this.edad > 18);
    }

    @Override
    public String toString () {
        String retorno = ("\n**********************************************\nNombre: " + this.nombre + "\nEdad: " + this.edad+ " años." + "\nDNI: "+ this.dni + ".\nPeso: " + this.peso + " kg." + "\nAltura: " + this.altura+ "m.\n**********************************************");
        return retorno;
    }


}
