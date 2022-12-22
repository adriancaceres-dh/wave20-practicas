package distribuidora;

public class Perecedero extends Producto {
	private int diasPorCaducar;

	public Perecedero(String nombre, double precio, int diasPorCaducar) {
		super(nombre, precio);
		this.diasPorCaducar = diasPorCaducar;
	}

	public int getDiasPorCaducar() {
		return diasPorCaducar;
	}

	public void setDiasPorCaducar(int diasPorCaducar) {
		this.diasPorCaducar = diasPorCaducar;
	}

	@Override
	public String toString() {
		return "Perecedero [Nombre " + getNombre() + " diasPorCaducar=" + diasPorCaducar + "]";
	}

	@Override
	public void calcular(int cantidadDeProductos) {
		super.calcular(cantidadDeProductos);
// Vamos a averiguar si es necesario reducir el valor del producto.
		if (diasPorCaducar == 1) {
			setPrecio(getPrecio() / 4);
		} else if (diasPorCaducar == 2) {
			setPrecio(getPrecio() / 3);
		} else if (diasPorCaducar == 3) {
			setPrecio(getPrecio() / 2);
		}
	}
}
