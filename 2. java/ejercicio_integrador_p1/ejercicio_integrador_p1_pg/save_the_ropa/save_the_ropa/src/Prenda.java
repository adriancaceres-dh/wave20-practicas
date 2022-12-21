public class Prenda {
    protected String marca, modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
}
