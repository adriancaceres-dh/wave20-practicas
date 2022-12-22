public class Vehiculo {
    String modelo;
    String marca;
    double costo;

    public Vehiculo(String marca, String modelo, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return  "\n"+marca +" "+ modelo + ", $" +costo;
    }
}
