public class Automovil {

    String marca;
    String color;
    double kilometros;

    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    public String mostrarMarcaYColor() {
        String marcaYColor = "La marca del auto es: " + marca + ". El color del auto es: " + color;

        return marcaYColor;
    }
}