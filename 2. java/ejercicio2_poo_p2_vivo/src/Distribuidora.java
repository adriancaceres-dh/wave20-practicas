import java.lang.reflect.Array;

public class Distribuidora {


    public static void main(String[] args) {


        Producto producto1 = new Producto("Mantequillas", 1900);
        Perecedero perecedero1 = new Perecedero("Lechugas", 2500, 3);
        NoPerecedero noPerecedero1 = new NoPerecedero("Atunes", 8000, "Pescado");

        Producto[] productos = {producto1, perecedero1, noPerecedero1};


        for(Producto p : productos) {
            System.out.println(p.toString());
            System.out.println("Precio de 5 " + p.getNombre() + ": " + p.calcular(5) + "\n");
        }

    }

}
