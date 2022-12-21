package EjercicioIntegradorP1;

import java.util.List;
import java.util.stream.Collectors;

public class Factura {
    private int codigo;
    private Cliente datos;
    private List<Item> itemList;
     private double totalFactura;

    public Factura() {
    }

    public Factura(int codigo, Cliente datos, List<Item> itemList, double totalFactura) {
        this.codigo = codigo;
        this.datos = datos;
        this.itemList = itemList;
        this.totalFactura = totalFactura;
    }

    public static double totalFactura(List<Item> itemLis){
        double total = itemLis.stream().mapToDouble(Item::getCostoUnitario).sum();
        return total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Cliente getDatos() {
        return datos;
    }

    public void setDatos(Cliente datos) {
        this.datos = datos;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
