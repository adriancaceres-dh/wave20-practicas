import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.function.Predicate;

public class Garage {
    private int Id;
    private Collection<Vehiculo> Vehiculos = new ArrayList<>();

    public Garage() {
    }
    public Garage(int id, Collection<Vehiculo> vehiculos) {
        Id = id;
        Vehiculos = vehiculos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Collection<Vehiculo> getVehiculos() {
        return Vehiculos;
    }

    public void addVehiculo(Vehiculo v) {
        Vehiculos.add(v);
    }
    public void addVehiculos(Collection<Vehiculo> v) {
        Vehiculos.addAll(v);
    }

    public Collection<Vehiculo> sortVehiculos(Comparator<Vehiculo> comparator) {
        return Vehiculos.stream().sorted(comparator).toList();
    }
    public Collection<Vehiculo> filterVehicle(Predicate<Vehiculo> predicado) {
        return Vehiculos.stream().filter(predicado).toList();
    }
}
