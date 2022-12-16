public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso; //tiene que estar en kg
    double altura; //tiene que estar en mts

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

    public int calcularIMC() {
        //para luego: tener en cuenta el caso de que la altura sea cero porque no fue ingresada o se utilizo un constructor que no considera la altura.
        double IMC = peso/(Math.pow(altura,2));
        if (IMC<20) return -1;
        else if (IMC>=20 && IMC<=25) return 0;
        else return 1;
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso + "kg" +
                ", altura=" + altura + "mts" +
                '}';
    }
}
