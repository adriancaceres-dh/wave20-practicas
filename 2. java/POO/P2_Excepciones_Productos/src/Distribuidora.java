import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[10];
        productos[0] = new Perecedero("Producto perecedero 1",100d,2);
        productos[1] = new Perecedero("Producto perecedero 2",200d, 1);
        productos[2] = new Perecedero("Producto perecedero 3",300d, 2);
        productos[3] = new Perecedero("Producto perecedero 4",400d, 3);
        productos[4] = new Perecedero("Producto perecedero 5",500d, 4);
        productos[5] = new NoPerecedero("Producto no perecedero 1",100d, "tipo 1");
        productos[6] = new NoPerecedero("Producto no perecedero 1", 200d,"tipo 2");
        productos[7] = new NoPerecedero("Producto no perecedero 1", 300d, "tipo 3");
        productos[8] = new NoPerecedero("Producto no perecedero 1", 400d, "tipo 4");
        productos[9] = new NoPerecedero("Producto no perecedero 1", 500d, "tipo 5");
        double sumaTotal = 0;
        Scanner scanner = new Scanner(System.in);
        int cantidadDeProductos;

        for (Producto producto: productos) {
            System.out.println("Ingrese la cantidad del productos para " + producto.getNombre());
            cantidadDeProductos = scanner.nextInt();
            sumaTotal += producto.calcular(cantidadDeProductos);
        }

        System.out.println("Suma Total = " + sumaTotal);
        System.out.println(productos[0]);



    }
}
