public abstract class Reserva {
    private String idReserva;
    private String nombre;
    private double precio;


    public Reserva(){}
    public Reserva(String idReserva, String nombre, double precio) {
        this.idReserva = idReserva;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
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
}
