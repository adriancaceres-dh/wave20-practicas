import java.util.*;

public class Carrera {
    private double Distancia;
    private double PremioEnDolares;
    private String Nombre;
    private int CantidadDeVehiculos;
    private List<Vehiculo> ListaDeVehiculos = new ArrayList<Vehiculo>();

    private Socorrista<Auto> SocorristaAuto = new Socorrista<>();
    private  Socorrista<Moto> SocorristaMoto = new Socorrista<>();
    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculos) {
        Distancia = distancia;
        PremioEnDolares = premioEnDolares;
        Nombre = nombre;
        CantidadDeVehiculos = cantidadDeVehiculos;
    }

    public double getDistancia() {
        return Distancia;
    }

    public double getPremioEnDolares() {
        return PremioEnDolares;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getCantidadDeVehiculos() {
        return CantidadDeVehiculos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return ListaDeVehiculos;
    }

    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(ListaDeVehiculos.stream().count()<CantidadDeVehiculos)
            ListaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
    }
    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro, String patente){
        if(ListaDeVehiculos.stream().count()<CantidadDeVehiculos)
            ListaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));

    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        ListaDeVehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente){
        Optional<Vehiculo> vehiculo1 = ListaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst();
        if(vehiculo1.isPresent())
            ListaDeVehiculos.remove(vehiculo1);
    }

    public Vehiculo definirGanador(){
        Optional<Vehiculo> vehiculo1 = ListaDeVehiculos.stream().max(Comparator.comparing(vehiculo ->vehiculo.getVelocidad()*(vehiculo.getAceleración()/2)/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso())- vehiculo.getRuedas()*100)));
        if (vehiculo1.isPresent())
            return vehiculo1.get();
        throw new RuntimeException("Vehiculo no encontrado");
    }

    public String socorrerAuto(String patente){
        Optional<Vehiculo> vehiculo1 = ListaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst();
        if (vehiculo1.isPresent() && vehiculo1.get() instanceof Auto)
            return SocorristaAuto.socorrer((Auto) vehiculo1.get());
        throw new RuntimeException("Auto no encontrado");

    }
    public String socorrerMoto(String patente){
        Optional<Vehiculo> vehiculo1 = ListaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst();
        if (vehiculo1.isPresent() && vehiculo1.get() instanceof Moto)
            return SocorristaMoto.socorrer((Moto) vehiculo1.get());
        throw new RuntimeException("Moto no encontrada");

    }
}
