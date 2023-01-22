import com.bootcamp.NoPerecedero;
import com.bootcamp.Perecedero;
import com.bootcamp.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> distribuidora = new ArrayList<>();
        Producto p1 = new NoPerecedero("atun", 20.5, "concervas");
        Producto p2 = new NoPerecedero("avena", 10.0, "cereales");
        NoPerecedero p3 = new NoPerecedero("arroz", 5.2, "cereales");
        Producto p4 = new Perecedero("queso",20.8, 3);
        Perecedero p5 = new Perecedero("carne", 28.4, 1);
        Perecedero p6 = new Perecedero("yogurt", 9.9, 2);
        NoPerecedero p7 = new NoPerecedero("café", 100.0, "infusiones");
        NoPerecedero p8 = new NoPerecedero("maní", 20.1, "frutos secos");
        Perecedero p9 = new Perecedero("fruilla", 120.0,2);
        Perecedero p10 = new Perecedero("crema", 10.10, 10);


        distribuidora.add(p1);
        distribuidora.add(p2);
        distribuidora.add(p3);
        distribuidora.add(p4);
        distribuidora.add(p5);
        distribuidora.add(p6);
        distribuidora.add(p7);
        distribuidora.add(p8);
        distribuidora.add(p9);
        distribuidora.add(p10);

        System.out.println("distri:" + distribuidora.toString());
            double total = 0;
        for(Producto prod : distribuidora) {
                    total +=  prod.calcular(5);
            System.out.println("producto: " + prod.getNombre() + " " + prod.calcular(1));
        }
            System.out.println("Total: " + total);


        }
    }
