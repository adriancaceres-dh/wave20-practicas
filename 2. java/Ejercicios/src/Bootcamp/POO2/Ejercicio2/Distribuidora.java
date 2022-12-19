package Bootcamp.POO2.Ejercicio2;

public class Distribuidora {
    public static void main(String[] args) {

        double calcular = 0;

        Producto[] productos = new Producto[10];
        productos[0] = new Perecedero("Frijoles", 5500, 2);
        productos[1] = new Perecedero("Yuca", 4500, 3);
        productos[2] = new Perecedero("Chocolate", 9000, 1);
        productos[3] = new Perecedero("Mazorca", 1500, 3);
        productos[4] = new Perecedero("Arroz", 11500, 3);
        productos[5] = new NoPerecedero("Clorox", 3500, "Limpieza");
        productos[6] = new NoPerecedero("Camiseta", 15000, "Vestimenta");
        productos[7] = new NoPerecedero("Zapatos", 23500, "Vestimenta");
        productos[8] = new NoPerecedero("Computadora", 21500, "Tecnologia");
        productos[9] = new NoPerecedero("Medias", 22500, "Vestimenta");

        for(Producto producto: productos){
            calcular += producto.Calcular(5);
            System.out.println(calcular);
        }
    }
}
