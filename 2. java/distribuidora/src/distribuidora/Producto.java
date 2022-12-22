package distribuidora;

public class Producto {
	private String nombre;
	private double precio;

	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
	}

	public void calcular(int cantidadDeProductos) {
		// multiplicamos el precio por la cantidad de productos para obtener el valor
		// total.
		double valorTotal = precio * cantidadDeProductos;
		precio = valorTotal;
	}
}
