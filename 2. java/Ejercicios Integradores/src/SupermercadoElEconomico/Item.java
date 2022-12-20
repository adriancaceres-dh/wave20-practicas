package SupermercadoElEconomico;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitario;

    public Item(String codigo, String nombre, int costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = 0;
        this.costoUnitario = costoUnitario;
    }
}
