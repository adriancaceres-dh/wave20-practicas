package com.bootcamp;

import com.bootcamp.model.Cliente;
import com.bootcamp.model.Factura;
import com.bootcamp.model.Item;
import com.bootcamp.repository.ClienteImpl;
import com.bootcamp.repository.FacturaImpl;
import com.bootcamp.repository.ItemImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Creo instancias de las clases
        ClienteImpl clienteImpl = new ClienteImpl();
        FacturaImpl facturaImpl = new FacturaImpl();
        ItemImpl itemImpl = new ItemImpl();

        // Creo objetos Cliente
        Cliente cliente1 = new Cliente(123456L, "Lio", "Messi");
        Cliente cliente2 = new Cliente(457891L, "Fideo", "DiMaria");
        Cliente cliente3 = new Cliente(7865445L, "Rodri", "DePaul");

        // Guardo los clientes en la lista
        clienteImpl.guardar(cliente1);
        clienteImpl.guardar(cliente2);
        clienteImpl.guardar(cliente3);

        // Creo objetos de tipo Item y los guardo en la lista
        Item item1 = new Item(4565L, "Carne", 1, 500.0);
        itemImpl.guardar(item1);
        Item item2 = new Item(4567L, "Verduras", 1, 200.0);
        itemImpl.guardar(item2);

        // Pido que ingresen un DNI para realizar la factura
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el DNI para facturar");
        Long dniABuscar = teclado.nextLong();

        // Si encuentra el DNI en la lista creo una Factura con los datos ese Cliente
        if(clienteImpl.buscar(dniABuscar).isPresent()){
            String nombreEncontrado = clienteImpl.buscar(dniABuscar).get().getNombre();
            String apellidoEncontrado = clienteImpl.buscar(dniABuscar).get().getApellido();
            // Llamo a la funcion 'buscarTodos' para agregar los items a la Factura y a la funcion 'calcular' para calcular el precio total
            Factura factura = new Factura(456L,clienteImpl.verificar(dniABuscar, nombreEncontrado, apellidoEncontrado),itemImpl.buscarTodos(), itemImpl.calcular());
            // Guardo la factura en la lista
            facturaImpl.guardar(factura);
        }else{
            // Si no en cuentra un cliente con ese dni en la lista pido nombre y apellido para crear un nuevo Cliente
            // y crear una Factura con esos datos
            System.out.println("Ingrese su nombre");
            String nuevoNombre = teclado.next();
            System.out.println("Ingrese su apellido");
            String nuevoApellido = teclado.next();

            Factura factura = new Factura(456L,clienteImpl.verificar(dniABuscar, nuevoNombre, nuevoApellido),itemImpl.buscarTodos(), itemImpl.calcular());
            facturaImpl.guardar(factura);
        }

        // Muestro las facturas
        facturaImpl.mostrar();

        // Muestro los clientes
        clienteImpl.mostrar();

        // Pido un DNI para buscar un CLiente
        System.out.println("Ingrese el DNI del cliente a buscar");
        Long dniBuscar = teclado.nextLong();
        clienteImpl.buscar(dniBuscar);

        // Pido un DNI para eliminar un Cliente
        System.out.println("Ingrese el DNI del cliente que desea borrar");
        Long dniBorrar = teclado.nextLong();
        clienteImpl.eliminar(dniBorrar);

    }
}