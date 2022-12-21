import java.util.List;

public class Localizador {
    List<Reserva> reservas;
    int id;
    public Localizador()
    {

    }

    public Localizador(List<Reserva> reservas, int id) {
        this.reservas = reservas;
        this.id = id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
