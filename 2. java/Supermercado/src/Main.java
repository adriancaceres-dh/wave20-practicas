import com.bootcamp.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cli = new Cliente("17671173-6","Armando","Burdiles");
        Cliente cli2 = new Cliente("17671173-7","Javiera","Reveco");
        Cliente cli3 = new Cliente("17671173-8","Belen","Burdiles");
        Scanner tec = new Scanner(System.in);
        String busqueda = "";
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cli);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        listaClientes.stream().forEach(System.out::println);
        System.out.println("__________________");

        System.out.println(listaClientes.removeIf(x->x.getNombre().equals("Armando")));

        System.out.println("__________________");
        listaClientes.stream().forEach(System.out::println);
        System.out.println("____________");
        busqueda = tec.nextLine();
        String finalBusqueda = busqueda;
        Optional<Cliente> temp= listaClientes.stream().filter(x->x.getDni().equals(finalBusqueda)).findFirst();
        if(temp.isEmpty()){
            System.out.println("El cliente no se encuentra");
        }else {
            temp.stream().forEach(System.out::println);
        }




    }
}