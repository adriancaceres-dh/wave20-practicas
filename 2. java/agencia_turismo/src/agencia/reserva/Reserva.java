package agencia.reserva;

public class Reserva {
    private TipoReserva tipoReserva;
    private double costo;

    public Reserva(TipoReserva tipoReserva, double costo) {
        this.tipoReserva = tipoReserva;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
