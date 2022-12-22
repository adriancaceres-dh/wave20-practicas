package distribuidora;

public class Distribuidora {
	public static void main(String[] args) {
		Producto[] productos = new Producto[5];
		productos[0] = new Producto("Bananas", 500);
		productos[1] = new Producto("Carne", 1500);
		productos[2] = new Producto("Gaseosas", 700);
		productos[3] = new Producto("Chocolate", 2000);
		productos[4] = new Producto("Lentejas", 300);
		productos[0].calcular(6);
		Perecedero carne = new Perecedero(productos[1].getNombre(), productos[0].getPrecio(), 2);
		carne.calcular(6);
		productos[1] = new Producto("carne", carne.getPrecio());
		productos[2].calcular(4);
		productos[3].calcular(10);
		NoPerecedero lentejas = new NoPerecedero(productos[4].getNombre(), productos[4].getPrecio(), "grano");
		lentejas.calcular(30);
		productos[4] = new Producto("lentejas", lentejas.getPrecio());
		for (int i = 0; i < productos.length; i++) {
			System.out.println(productos[i].toString());
		}
	}
}
