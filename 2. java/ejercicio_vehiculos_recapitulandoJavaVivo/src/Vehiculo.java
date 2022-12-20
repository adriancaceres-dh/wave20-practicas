public class Vehiculo implements Comparable{

    private String modelo;
    private String marca;
    private Double costo;

    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }

    @Override
    public int compareTo(Object c) {
        Vehiculo v = (Vehiculo)c;
        if(this.marca.compareTo(v.marca) == 0){
            return this.costo.compareTo(v.costo);
        }
        return this.marca.compareTo(v.marca);
    }

}
