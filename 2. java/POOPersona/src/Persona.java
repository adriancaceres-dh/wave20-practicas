public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(double peso, double altura) {
        try {
            if (!(altura == 0.0)) {
                double icm = (peso / (altura * altura));
                System.out.println("icm = " + icm);

                if (icm < 20) {
                    return -1;
                }
                if (icm >= 20 && icm <= 25) {
                    return 0;
                }
                if (icm > 25) {
                    return 1;
                }
            } else {
                //throw new IllegalArgumentException("No se puede dividir por cero!");
                throw new ArrayIndexOutOfBoundsException("No se puede dividir por cero!");
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean esMayorDeEdad(int edad) {
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
