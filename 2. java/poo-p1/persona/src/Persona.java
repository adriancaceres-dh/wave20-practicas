public class Persona {
    String nombre;
    Integer edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
        this.nombre = null;
        this.edad = null;
        this.dni = null;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, Integer edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        double imc = Math.round(this.peso / Math.pow(this.altura, 2));
        String mensaje = nombre + " tiene un nivel de peso ";
        Integer salida;

        if(imc < 20.0) {
            salida = -1;
            mensaje += "bajo";
        } else if (imc > 25.0) {
            salida = 1;
            mensaje += "saludable";
        } else {
            salida = 0;
            mensaje = "alto";
        }

        System.out.println(mensaje);
        return salida;
    }

    public boolean esMayorDeEdad() {
        boolean esMayor = this.edad >= 18;
        String mensaje = " ha alcanzado la mayoría de edad.";
        if (!esMayor) {
            mensaje = "no" + mensaje;
        }
        System.out.println(nombre + mensaje);
        return esMayor;
    }

    @Override
    public String toString() {
        String salida = "Nombre: " + this.nombre + "\n";
        salida += "Edad: " + this.edad + "\n";
        salida += "Documento: " + this.dni + "\n";
        salida += "Peso: " + this.peso + " kg\n";
        salida += "Altura: " + this.altura + " mts\n";

        return salida;
    }
}
