package com.bootcamp;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String name, int edad, String dni) {
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int cacularIMC() {
        if (altura == 0) {
            return 2;
        }
        double iMC = peso / Math.pow(altura, 2);
        System.out.println("Nivel de peso es:");
        if (iMC < 20) {
            System.out.print("Bajo de peso con un IMC de ");
            return -1;
        } else if (iMC >= 20 && iMC <= 25) {
            System.out.print("Peso saludable con un IMC de ");
            return 0;
        } else {
            System.out.print("Sobrepeso con un IMC de ");
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        System.out.println("Es mayor de edad: ");
        return edad >= 18;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
