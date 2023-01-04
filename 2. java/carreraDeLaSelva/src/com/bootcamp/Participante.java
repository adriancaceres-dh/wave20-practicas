package com.bootcamp;

public class Participante {
    String dni, nombre, apellido, celular, nroEmergencia, grupoSanguineo;
    int edad, monto, nroParticipante;

    public Participante() {
    }

    public Participante(String dni, String nombre, String apellido, String celular, String nroEmergencia, String grupoSanguineo, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.edad = edad;
    }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCelular() { return celular; }

    public void setCelular(String celular) { this.celular = celular; }

    public String getNroEmergencia() { return nroEmergencia; }

    public void setNroEmergencia(String nroEmergencia) { this.nroEmergencia = nroEmergencia; }

    public String getGrupoSanguineo() { return grupoSanguineo; }

    public void setGrupoSanguineo(String grupoSanguineo) { this.grupoSanguineo = grupoSanguineo; }

    public int getEdad() { return edad; }

    public void setEdad(int edad) { this.edad = edad; }

    public int getMonto() { return monto; }

    public void setMonto(int monto) { this.monto = monto; }

    public int getNroParticipante() { return nroParticipante; }

    public void setNroParticipante(int nroParticipante) { this.nroParticipante = nroParticipante; }

    @Override
    public String toString() {
        return "\nParticipante: " +
                "\ndni: " + dni +
                "\nnombre: '" + nombre + '\'' +
                "\napellido: '" + apellido + '\'' +
                "\ncelular: '" + celular + '\'' +
                "\nnroEmergencia: '" + nroEmergencia + '\'' +
                "\ngrupoSanguineo: '" + grupoSanguineo + '\'' +
                "\nedad: " + edad +
                "\nmonto: " + monto +
                "\nnroParticipante: " + nroParticipante + '\n';
    }
}
