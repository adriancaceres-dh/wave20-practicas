public class Distribuidora {
    public static void main(String[] args) {
        NoPerecedero productoDetalles = new NoPerecedero("Atun con champiñon", 7800, "Enlatados");
        Perecedero productoDetalles1 = new Perecedero("Pasta", 1300, 9);
        Perecedero productoDetalles2 = new Perecedero("Carne", 18000, 2);

        System.out.println(productoDetalles1.calcular(9));
        System.out.println(productoDetalles2.getNombre());
        System.out.println(productoDetalles.getPrecio());
    }
}