package ejercicio1;

public class Cliente {
    private String nombre;
    private String tipoCliente;

    public Cliente(String nombre, String tipoCliente) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCliente() {
        return this.tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String toString() {
        return "Cliente{nombre='" + this.nombre + "', tipoCliente='" + this.tipoCliente + "'}";
    }
}
