package agencia.reserva;

public class TipoReserva {
    private String nombre;
    private String detalle;

    public TipoReserva(String nombre) {
        this.nombre = nombre;
    }

    public TipoReserva(String nombre, String detalle) {
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
