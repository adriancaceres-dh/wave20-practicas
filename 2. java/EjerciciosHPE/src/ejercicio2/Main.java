package ejercicio2;

public class Main {
    public static void main(String[] args) {
        Perecedero productoPerecedero = new Perecedero(1,"Leche",200);
        Producto productoNormal = new Producto("Galletita",200);
        System.out.println(productoNormal.toString());
        System.out.println(productoNormal.calcular(1));
        System.out.println(productoPerecedero.toString());
        System.out.println(productoPerecedero.calcular(1));
    }
}
