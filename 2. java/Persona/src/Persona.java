public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre= nombre;
        this.edad= edad;
        this.dni= dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre= nombre;
        this.edad= edad;
        this.dni= dni;
        this.peso= peso;
        this.altura= altura;
    }

    public int calcularIMC(){
        double calculo = peso/(Math.pow(altura, 2));
        System.out.println(calculo);
        if(calculo < 20) return -1;
        if(calculo <= 25) return 0;
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
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
