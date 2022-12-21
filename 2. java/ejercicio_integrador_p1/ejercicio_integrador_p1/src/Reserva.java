import java.util.List;
import java.util.Map;

public class Reserva {
    protected int hotel, boletosDeViaje, comida, transporte;

    public Reserva(int hotel, int boletosDeViaje, int comida, int transporte) {
        this.hotel = hotel;
        this.boletosDeViaje = boletosDeViaje;
        this.comida = comida;
        this.transporte = transporte;
    }

    public int getHotel() {
        return hotel;
    }

    public int getBoletosDeViaje() {
        return boletosDeViaje;
    }

    public int getComida() {
        return comida;
    }

    public int getTransporte() {
        return transporte;
    }
}
