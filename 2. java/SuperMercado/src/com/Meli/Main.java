package com.Meli;

import com.Meli.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Cliente> clientes = new ArrayList<>();

       clientes.add(new Cliente(Long.parseLong("1"),"Juan", "Ortiz"));
       clientes.add(new Cliente(Long.parseLong("2"),"Carlos", "Reales"));
       clientes.add(new Cliente(Long.parseLong("3"),"Alfredo", "Pinzon"));

        Long dni;
        clientes.forEach( c -> System.out.println(c.toString()));

        Scanner capturar = new Scanner(System.in);
        System.out.println("Borrar persona");
        System.out.println("Digita el dni de la persona a elimiar: ");
        dni = capturar.nextLong();

        eliminarCliente(clientes, dni);

        clientes.forEach( c -> System.out.println(c.toString()));
        System.out.println("Buscar persona");
        System.out.println("Digita el dni de la persona a buscar: ");
        dni = capturar.nextLong();

        Cliente cliente = buscarCliente(clientes, dni);

        System.out.println(cliente != null ? cliente.toString(): "cliente no encontrado");

    }

    private static void eliminarCliente(List<Cliente> clientes, Long dni) {
        boolean bandera = false;
        Cliente cliente = buscarCliente(clientes, dni);
        if(cliente != null) bandera = true;
        if(bandera){
            try{
                clientes.remove(cliente);
                System.out.println("Cliente se elimino correctamente");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Cliente no registrado");
        }
    }

    private static Cliente buscarCliente(List<Cliente> list, Long dni){
        Cliente cliente = null;
        for (Cliente c: list){
            if(c.getDni() == dni) {
                cliente = c;
            }
        }
        return cliente;
    }


}
