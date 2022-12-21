public class Item {
    int codigo;
    String nombre;
    int totalVendida;
    double costo;

    public Item() {
    }

    public Item(int codigo, String nombre, int totalVendida, double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.totalVendida = totalVendida;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalVendida() {
        return totalVendida;
    }

    public void setTotalVendida(int totalVendida) {
        this.totalVendida = totalVendida;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", totalVendida=" + totalVendida +
                ", costo=" + costo +
                '}';
    }
}
