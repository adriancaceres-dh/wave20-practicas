import model.producto.NoPerecedero;
import model.producto.Perecedero;
import model.producto.Producto;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = {
                new NoPerecedero("Sal", 250.5, "Alimentos"),
                new NoPerecedero("Arroz", 90, "Alimentos"),
                new NoPerecedero("Azucar", 230, "Alimentos"),
                new NoPerecedero("Café", 450, "Alimentos"),
                new NoPerecedero("Harina", 70, "Alimentos"),
                new Perecedero("Leche", 150, 2),
                new Perecedero("Yogur", 300, 3),
                new Perecedero("Galletitas", 100, 1),
                new Perecedero("Otra Cosa", 10.50, 15),
                new Perecedero("Flan", 220, 6),
        };

        double acc = 0;
        for (Producto producto: productos) {
            acc += producto.calcular((int) (Math.random() * 5 + 1));
        }

        System.out.println("El precio total es: $" + acc);
    }
}