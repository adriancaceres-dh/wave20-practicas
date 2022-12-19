import java.util.Arrays;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[5];
        productos[0] = new NoPerecedero("leche", 5, "a");
        productos[1] = new NoPerecedero("cafe", 3, "b");
        productos[2] = new NoPerecedero("tomate", 15, "c");
        productos[3] = new NoPerecedero("lechuga", 32, "d");
        productos[4] = new NoPerecedero("maite", 7, "f");
        
    }
}
