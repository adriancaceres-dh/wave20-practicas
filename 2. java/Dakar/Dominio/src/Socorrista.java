public class Socorrista<T extends Vehiculo> {

    public String socorrer(T vehiculo){
        String tipo = vehiculo.getClass().getSimpleName();
        return "Socorriendo " +tipo.toLowerCase()+" patente "+ vehiculo.getPatente();
    }
}
