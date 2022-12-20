package com.bootcamp.clases;

public class Persona {

    String nombre;
    int edad;
    double salario;
    String nivelEscolar;
    String cargo;
    String empresa;

    public Persona(String nombre, int edad, double salario, String nivelEscolar, String cargo, String empresa) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.nivelEscolar = nivelEscolar;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
