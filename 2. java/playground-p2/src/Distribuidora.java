public class Distribuidora {
    public static void main(String[] args){
        Producto productos[] = new Producto[10];
        double total = 0;

        productos[0] = new Perecedero("jamón", 120.0, 3);
        productos[1] = new Perecedero("queso", 130.5, 2);
        productos[2] = new Perecedero("matambre", 110.25, 1);
        productos[3] = new Perecedero("mortadela", 101.08, 3);
        productos[4] = new Perecedero("salchichón", 108.90, 2);
        productos[5] = new NoPerecedero("arroz", 89.0, "blanco");
        productos[6] = new NoPerecedero("fideos", 79.0, "tallarines");
        productos[7] = new NoPerecedero("harina", 99.0, "0000");
        productos[8] = new NoPerecedero("sardinas", 89.0, "enlatados");
        productos[9] = new NoPerecedero("atún", 75.0, "enlatados");

        for (Producto producto: productos) total += producto.calcular(1);

        System.out.println(total);
    }
}
