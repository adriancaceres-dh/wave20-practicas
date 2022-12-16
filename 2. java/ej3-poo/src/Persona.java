public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(String nombre, int edad, String dni) {
        this.edad = edad;
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.edad = edad;
        this.nombre = nombre;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int cacularIMC() {
        double IMC = this.getPeso()/Math.pow(this.getAltura(),2.0);
        if(IMC < 20) return -1;
        else if(IMC > 25) return 1;
        else return 0;
    }

    public boolean esMayorDeEdad() {
        return this.getEdad() >= 18;
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
}
