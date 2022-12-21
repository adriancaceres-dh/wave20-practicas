public class Distribuidora {

    public static void main(String [] args) {
        Producto [] arrayProductos = new Producto[10];
        double precioFinal = 0;

        arrayProductos[0] = new Perecedero(500, "Harina", 3);
        arrayProductos[1] = new Perecedero(350, "Leche", 2);
        arrayProductos[2] = new Perecedero(400, "Huevos", 2);
        arrayProductos[3] = new Perecedero(450, "Yogur", 1);
        arrayProductos[4] = new Perecedero(800, "Carne", 3);
        arrayProductos[5] = new NoPerecedero(400, "Atun enlatado", "Tipo");
        arrayProductos[6] = new NoPerecedero(600, "Chocolate", "Tipo");
        arrayProductos[7] = new NoPerecedero(500, "Arvejas enlatadas", "Tipo");
        arrayProductos[8] = new NoPerecedero(400, "Choclo enlatado", "Tipo");
        arrayProductos[9] = new NoPerecedero(350, "Palmitos enlatados", "Tipo");

        for(Producto p : arrayProductos)
        {
            precioFinal+=p.calcular(5);
        }

        System.out.println("El precio final es de $" + String.format("%.2f",precioFinal) + ".");
    }
}
