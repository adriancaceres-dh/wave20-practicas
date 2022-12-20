package supermercado;

public class Producto {
    private long id;
    private String codigo;
    private double costoUnitario;
    private String nombre;

    public Producto(String codigo, double costoUnitario, String nombre) {
        this.codigo = codigo;
        this.costoUnitario = costoUnitario;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", costoUnitario=" + costoUnitario +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
