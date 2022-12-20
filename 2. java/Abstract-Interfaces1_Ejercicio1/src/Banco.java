import java.util.List;

public class Banco {
    String nombre;
    List<String[]> clientes;

    List<String[]> transacciones;

    public Banco() {
    }

    public Banco(String nombre, List<String[]> clientes, List<String[]> transacciones) {
        this.nombre = nombre;
        this.clientes = clientes;
        this.transacciones = transacciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String[]> getClientes() {
        return clientes;
    }

    public void setClientes(List<String[]> clientes) {
        this.clientes = clientes;
    }

    public List<String[]> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<String[]> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", clientes=" + clientes +
                ", transacciones=" + transacciones +
                '}';
    }

}

