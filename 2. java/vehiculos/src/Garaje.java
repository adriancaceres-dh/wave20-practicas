import java.util.ArrayList;
import java.util.List;

public class Garaje {

    private int id;
    private List<Vehiculo> vehiculoList;

    public Garaje(int id) {
        this.id = id;
        this.vehiculoList = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculoList.add(vehiculo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }


}