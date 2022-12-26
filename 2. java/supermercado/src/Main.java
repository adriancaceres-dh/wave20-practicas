import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClientImp cliImp = new ClientImp();

        Cliente c1 = new Cliente("123", "Snoop", "Dogg");
        Cliente c2 = new Cliente("234", "Pepe", "Platano");
        Cliente c3 = new Cliente("345", "Michael", "Scotch");

        cliImp.create(c1);
        cliImp.create(c2);
        cliImp.create(c3);

        cliImp.read();

        ItemImp itemImp = new ItemImp();

        Item i1 = new Item(123L, "Galletas Navideñas", 1, 990);
        Item i2 = new Item(234L, "Shampoo Tio Nacho", 1, 5990);
        Item i3 = new Item(345L, "Acondicionador Tio Nacho", 1, 5990);
        Item i4 = new Item(456L, "Monster Energy Drink", 6, 1350);
        Item i5 = new Item(567L, "Banana", 7, 350);
        Item i6 = new Item(678L, "Lecha Chocolatada", 2, 1900);
        Item i7 = new Item(789L, "Desodorante Nivea", 4, 1550);

        itemImp.create(i1);
        itemImp.create(i2);
        itemImp.create(i3);
        itemImp.create(i4);
        itemImp.create(i5);
        itemImp.create(i6);
        itemImp.create(i7);

        itemImp.read();

        itemImp.find("456");

        itemImp.delete("234");

        FacturaImp facImp = new FacturaImp();

        Factura f1 = new Factura(321L, c1, itemImp.listaItems);

        facImp.create(f1);

        facImp.read();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente a borrar");
        String dniBorrado = scanner.next();

        cliImp.delete(dniBorrado);

        System.out.println("Ingrese el dni del cliente a buscar");
        String dniBuscado = scanner.next();
        cliImp.find(dniBuscado);

    }
}