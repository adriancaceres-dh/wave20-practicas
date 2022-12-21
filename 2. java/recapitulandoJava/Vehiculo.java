package recapitulandoJava;

public class Vehiculo {
    String modelo;
    String marca;
    Integer costo;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }

    public Vehiculo(String modelo, String marca, int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getCosto() {
        return costo;
    }
}
