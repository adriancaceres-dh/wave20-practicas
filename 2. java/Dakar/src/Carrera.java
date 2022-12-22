import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;



    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro,patente));

    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro,patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo vehiculo = this.vehiculos
                .stream()
                .filter(v -> v.patente == unaPatente)
                .
        this.vehiculos.remove(vehiculo);
    }



    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "Distancia=" + distancia +
                ", PremioEnDolares=" + premioEnDolares +
                ", Nombre='" + nombre + '\'' +
                ", CantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
