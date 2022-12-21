public class Item {
    int codigo;
    String nombre;
    int totalVendida;
    int costo;

    public Item() {
    }

    public Item(int codigo, String nombre, int costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.totalVendida = 0;
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
    public void aumentarTotalVendida() {
        this.totalVendida += 1;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
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
