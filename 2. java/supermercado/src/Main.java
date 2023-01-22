import com.bootcamp.model.Cliente;
import com.bootcamp.model.Factura;
import com.bootcamp.model.Item;
import com.bootcamp.repository.ClienteImp;
import com.bootcamp.repository.FacturaImp;
import com.bootcamp.repository.ItemImp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        System.out.println("Supermercado el Económico!");

        ClienteImp cliImp = new ClienteImp();
        ItemImp itemImp = new ItemImp();
        FacturaImp facturaImp = new FacturaImp();

        Cliente c1 = new Cliente(123,"Randolph", "Carter");
        Cliente c2 = new Cliente(456,"Erich","Zann");
        Cliente c3 = new Cliente(789,"Juan","Romero");

        Item i1 = new Item(999, "Arroz", 10.5, 2);
        Item i2 = new Item(990, "Jabón", 12.2, 1);
        Item i3 = new Item(970, "Galletitas", 10.0, 2);

        List<Item> items = Arrays.asList(i1,i2,i3);
        Factura f1 = new Factura(001,c1, items,40.2 );
        Factura f2 = new Factura(002,c2, items, 40.2);

        System.out.println("///// CRUD CLIENTE////////////");
        // GUARDAR CLIENTE
        cliImp.save(c1);
        cliImp.save(c2);

        // MOSTRAR CLIENTES POR PANTALLA
        cliImp.mostrarPantalla();

        //BUSCAR UN CLIENTE
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que desea encontrar");
        Integer search = scanner.nextInt();
        cliImp.buscar(search);

       //ELIMINAR CLIENTE
        System.out.println("Ingrese el cliente a borrar");
        Integer idBorrar = scanner.nextInt();
        cliImp.eliminar(idBorrar);

        //BUSCAR TODOS LOS CLIENTES
        cliImp.traerTodos();

        System.out.println("///// CRUD ITEM////////");

        //GUARDAR ITEM
         itemImp.save(i1);
         itemImp.save(i2);
         itemImp.save(i3);

         //MOATRAR ITEM
        itemImp.mostrarPantalla();

        //BUSCAR ITEM
        System.out.println("Ingrese el código del item a buscar");
        Integer id_i = scanner.nextInt();
        itemImp.buscar(id_i);

        //BORRAR ITEM
        System.out.println("Ingrese el código del item a borrar");
        Integer i_delete = scanner.nextInt();
        itemImp.eliminar(i_delete);

        //TRAER TODOS LOS ITEMS
        itemImp.traerTodos();

        System.out.println("///// CRUD FACTURA////////");
        //GUARDAR FACTURA
        facturaImp.save(f1);
        facturaImp.save(f2);

        //MOSTRAR PANTALLA
        facturaImp.mostrarPantalla();

        //BUSCAR FACTURA
        System.out.println("Ingrese el id de la factura a buscar");
        Integer id_f = scanner.nextInt();
        facturaImp.buscar(id_f);

        //ELIMINAR FACTURA
        System.out.println("Ingrese el id de la factura a borrar");
        Integer f_delete = scanner.nextInt();
        facturaImp.eliminar(f_delete);

        //TRAER TODAS LAS FACTURAS
        facturaImp.traerTodos();
    }
}