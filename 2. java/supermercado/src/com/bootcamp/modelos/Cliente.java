package com.bootcamp.modelos;

import java.util.List;

public class Cliente {
    //dni, nombre y apellido
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static Cliente mostrarCliente(String dni, List<Cliente> clientes){
        for (Cliente cliente :clientes) {
            if(dni.equals(cliente.getDni())) return cliente;
        }
        return null;
    }


    public static void removerCliente(List<Cliente> clientes, String dni){
        for (int i = 0; i < clientes.size(); i++) {
            Cliente clienteActual = clientes.get(i);
            if(clienteActual.getDni().equals(dni)){
                clientes.remove(i);
                return;
            }
        }
    }

    public static List<Cliente> agregarCliente(List<Cliente> clientes, Cliente nuevoCliente){
        boolean existeCliente = clientes.stream().anyMatch(cliente -> cliente.getDni().equals(nuevoCliente.getDni()));
        if(!existeCliente){
            clientes.add(nuevoCliente);
        }
        return clientes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
