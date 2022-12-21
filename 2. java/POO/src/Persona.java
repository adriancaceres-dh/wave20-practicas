public class Persona {
    // Se le asigna variable tipo String porque es un nombre, es decir, una cadena de carácteres.
    private String nombre;

    // Representa la edad, en números enteros > 0, por lo tanto debe ir en int.
    private int edad;

    // Si bien en Uruguay son solo números, en otros paises está compuesta por letras también.
    private String dni;

    // Valor que posee una parte entera y otra decimal donde se representan los gramos que faltan para llegar
    // al kg. Ej. 86.3kg -> 86kg. y 300gr.
    private double peso;

    // Valor que posee una parte entera y otra decimal donde se representan los centímetros que faltan para
    // legar al metro. Ej. 1.79m -> 1 metro y 79 centímetros.
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

    public int calcularIMC() {
        try {
            double imc = peso / (Math.pow(altura, 2));

            if (imc < 20) {
                return -1;
            } else if (imc >= 20 && imc <= 25) {
                return 0;
            } else {
                return 1;
            }
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
        }
        return 2; // Si llega aquí es un error.
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
