public class Persona {
    private String nombre;

    private int edad;

    private String dni;

    private double peso;

    private double altura;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

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
        try{
            double imc = peso/(Math.pow(altura,2));

            if (imc<20) {
                return -1;
            } else if (imc>=20  && imc<=25) {
                return 0;
            }
            else{
                return 1;
            }
        }catch (ArithmeticException ex){
            System.out.println(ex.getMessage());
        }
        return 2; // Si llega aquí es un error.
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
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
