package ejercDistribuidora;

public class NoPerecedero extends Producto {
    private String tipo;
    public NoPerecedero(String nombre, double precio) {
        super(nombre, precio);
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public double calcular(int cantidadDeProductos) throws Exception {
        return super.calcular(cantidadDeProductos);
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
