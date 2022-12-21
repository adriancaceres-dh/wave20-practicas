public class Distribuidora {
    public static void main(String[] args) {

        Perecedero manzana = new Perecedero(3, "Manzana", 2000);
        Perecedero pera = new Perecedero(4, "Pera", 2300);
        Perecedero tomate = new Perecedero(5, "Tomate", 3000);
        NoPerecedero pasta = new NoPerecedero("Pasta", "Espagueti", 4550);
        NoPerecedero maiz = new NoPerecedero("Frutos Frescos", "Maiz", 5550);
        NoPerecedero mani = new NoPerecedero("Frutos Frescos", "Mani", 9550);

        Producto productos[] = {manzana, pera, tomate, pasta, maiz, mani};

        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre() + " Valor Total 5 productos $ " + producto.calcular(5));
        }
    }
}