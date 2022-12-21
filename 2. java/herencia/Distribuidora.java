package herencia;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[2];
        productos[0]= new Perecedero(2,"perecedero1",50.5);
        productos[1] = new NoPerecedero("nPerecedero1",40,"tipo");

    }
}
