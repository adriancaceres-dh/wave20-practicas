package supermercadoEconocmico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Comprar {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("Tammara","Trivelli","12343");
        Cliente cliente2 = new Cliente("Maria","Rodriguez","23436");
        Cliente cliente3 = new Cliente("Rodrigo","Milan","56783");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.stream().forEach((c)->{System.out.println("Nombre de cliente: "+ c.getNombre());
                                        System.out.println("Apellido del cliente: "+ c.getApellido());
                                        System.out.print("dni del cliente: "+ c.getDni());
                                        System.out.println("\n");});
        System.out.println("------------Elimino el cliente Maria----------------");
        clientes.remove(cliente2);
        clientes.stream().forEach((c)->{System.out.println("Nombre de cliente: "+ c.getNombre());
                                        System.out.println("Apellido del cliente: "+ c.getApellido());
                                        System.out.print("dni del cliente: "+ c.getDni());
                                        System.out.println("\n");});

        System.out.println("Ingrese el dni del cliente que desea buscar");
        String dni;
        Scanner op = new Scanner(System.in);
        dni = op.nextLine();
        List<Cliente> clienteEncontrado = clientes.stream().filter(c->c.getDni().equals(dni)).collect(Collectors.toList());
        if(clienteEncontrado.isEmpty()){
            System.out.println("--------------Usuario no encontrado--------------");
        }else{
            clienteEncontrado.stream().forEach(System.out::println);
        }
        List<Factura> facturas = new ArrayList<>();
        boolean noTermino = true;
        List<Producto> productos = new ArrayList<>();
         //Controla que dos clientes no tengan el mismo id, si lo encuentra no crea uno nuevo
        Producto producto1 = new Producto("1","Carne",1,20);
        Producto producto2 = new Producto("2","Arroz",2,13);
        productos.add(producto1);
        productos.add(producto2);
        //Tengo que hacer el calculo de cuanto va a salir  cantidad de compra * costo unitario, y sumar
        //Antes de crear la factura vamos a calcularlo
        Integer result = productos.stream().mapToInt(p->p.getCantidadComprada()*p.getCostoUnitario()).sum();

         while(noTermino){
             System.out.println("-----vamos a crear una nueva factura-----");
             System.out.println("Ingrese el dni del cliente al cual se quiere asociar la factura");
             String dni1;
             Scanner op1 = new Scanner(System.in);
             dni1 = op1.nextLine();
             List<Cliente> clientesFiltrados = clientes.stream().filter(c->c.getDni().equals(dni1)).collect(Collectors.toList());
             if(clientesFiltrados.isEmpty()){
                 System.out.println("El cliente no se encuentra en el sistema, debe crear el cliente: ");
                 String nombre;
                 System.out.println("ingrese el nombre del cliente");
                 Scanner nom = new Scanner(System.in);
                 nombre = nom.nextLine();
                 String apellido;
                 System.out.println("ingrese el apellido del cliente");
                 Scanner apelli = new Scanner(System.in);
                 apellido = apelli.nextLine();
                 Cliente clienteAAgregar = new Cliente(nombre,apellido,dni1);
                 clientes.add(clienteAAgregar);
                 System.out.println("le asociaremos una lista de productos al cliente ingresado (Lo hara el sistema): ");
                 //Creamos la factura
                 Factura factura = new Factura(clienteAAgregar,result);
                 factura.agregarProducto(producto1);
                 factura.agregarProducto(producto2);
                 facturas.add(factura);
             }else{
                 Factura factura2 = new Factura(clientesFiltrados.get(0),result);
                 factura2.agregarProducto(producto1);
                 factura2.agregarProducto(producto2);
                 facturas.add(factura2);
             }
             //Vamos a imprimir la factura (Para ver si quedo bien)
             facturas.stream().forEach(System.out::println);

             System.out.println("Quiere seguir probando?");
             System.out.println("1-Si");
             System.out.println("2-No");
             int op2;
             Scanner op3 = new Scanner(System.in);
             op2 = op3.nextInt();
             if(op2 == 2) noTermino=false;
         }
    }
}
