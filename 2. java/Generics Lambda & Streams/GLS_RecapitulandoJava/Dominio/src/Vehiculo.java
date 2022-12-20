public class Vehiculo {

    private String Modelo;
    private String Marca;
    private double Costo;

    public Vehiculo(String modelo, String marca, double costo) {
        Modelo = modelo;
        Marca = marca;
        Costo = costo;
    }
    public Vehiculo(){}
    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double costo) {
        Costo = costo;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "Modelo='" + Modelo + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Costo=" + Costo +
                '}';
    }
}
