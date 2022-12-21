package distribuidora;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Producto blisterJamon = new Perecedero("jamón cocido",500,1);
        productos.add(blisterJamon);
        Producto panLactal = new Perecedero("pan lactal",350,2);
        productos.add(panLactal);
        Producto mermelada = new Perecedero("jamón cocido",280.50,3);
        productos.add(mermelada);
        Producto quesoCremoso = new Perecedero("queso cremoso",790,1);
        productos.add(quesoCremoso);
        Producto aceitunas = new Perecedero("aceitunas",640,2);
        productos.add(aceitunas);
        Producto arroz = new NoPerecedero("arroz",300);
        productos.add(arroz);
        Producto fideoTirabuzon = new NoPerecedero("fideo tirabuzon",400);
        productos.add(fideoTirabuzon);
        Producto aceite = new NoPerecedero("aceite",600);
        productos.add(aceite);
        Producto sal = new NoPerecedero("sal",250);
        productos.add(sal);
        Producto pimienta = new NoPerecedero("pimienta",500);
        productos.add(pimienta);
        
        double totalPagar = 0;
        for (Producto producto : productos) {
            totalPagar += producto.calcular(1);
        }
        System.out.println("PRODUCTOS QUE COMPRA: \n" + productos);
        System.out.println("TOTAL A PAGAR: " + Math.round(totalPagar * 100.0)/100.0);
        
    }
}
