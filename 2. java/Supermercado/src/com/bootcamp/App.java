package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public void agregarFactura(Factura nuevaFactura,Clienteimp clientesCRUD,Facturaimp facturasCRUD){
        Cliente clienteFactura=nuevaFactura.getCliente();
        Optional<Cliente> validacionCliente=clientesCRUD.buscar(clienteFactura.getDni());
        if(validacionCliente.isEmpty()) clientesCRUD.guardar(clienteFactura);
        facturasCRUD.guardar(nuevaFactura);


    }
    public static void main(String[] args) {
        Clienteimp clientesCRUD=new Clienteimp();
        Facturaimp facturasCRUD=new Facturaimp();

        Cliente cliente1=new Cliente("10456","pepe","perez");
        Cliente cliente2=new Cliente("10678","carlos","torres");
        Cliente cliente3=new Cliente("12958","maria","carvajal");

        //guardar clientes
        clientesCRUD.guardar(cliente1);
        clientesCRUD.guardar(cliente2);
        clientesCRUD.guardar(cliente3);

        Scanner teclado=new Scanner(System.in);

        //Buscar cliente
        System.out.println("Ingrese el dni del cliente a buscar:");
        String dni=teclado.next();
        clientesCRUD.buscar(dni);

        //Eliminar cliente
        System.out.println("Ingrese el dni del cliente a eliminar:");
        dni=teclado.next();
        clientesCRUD.eliminar(dni);



    }
}
