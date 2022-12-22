import java.util.ArrayList;
import java.util.List;

public class Garaje {
    int identificador;
    List<Vehiculo> vehiculos;

    public Garaje(int identificador, List<Vehiculo> vehiculos) {
        this.identificador = identificador;
        this.vehiculos = vehiculos;
    }

    public int getIdentificador() {
        return identificador;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
