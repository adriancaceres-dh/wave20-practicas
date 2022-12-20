import SupermercadoElEconomico.Cliente;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("########### EJERCICIO DEL SUPERMERCADO ´EL ECONÓMICO´ ###########");
        Cliente C1 = new Cliente(51907552,"Emanuel", "Fonseca");
        Cliente C2 = new Cliente(51907553,"Adrián", "Cáceres");
        Cliente C3 = new Cliente(51907552,"Luis", "Suárez");

        LinkedList<Cliente> clientes = new LinkedList<>();
        clientes.add(C1);
        clientes.add(C2);
        clientes.add(C3);

        clientes.forEach(System.out::println);
        System.out.println();
        clientes.remove(C1);
        clientes.forEach(System.out::println);
        System.out.println();

        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese CI de la persona a buscar: ");
        try{
            int ciBuscar = Integer.parseInt(lectura.next());
            List<Cliente> encontrado = clientes.stream().filter(x->x.getDni()==ciBuscar).collect(Collectors.toList());
            if(encontrado.isEmpty()){
                System.out.println("El usuario no existe.");
            }else{
                System.out.println(encontrado.remove(0));
            }
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}