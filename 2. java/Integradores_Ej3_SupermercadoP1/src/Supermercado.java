import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Supermercado {
    String nombre;
    List<Item> items;
    List<Cliente> clientes;
    List<Factura> facturas;

    public Supermercado() {
    }

    public Supermercado(String nombre, List<Item> items, List<Cliente> clientes, List<Factura> facturas) {
        this.nombre = nombre;
        this.items = items;
        this.clientes = clientes;
        this.facturas = facturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre='" + nombre + '\'' +
                ", items=" + items +
                ", clientes=" + clientes +
                ", facturas=" + facturas +
                '}';
    }

    public boolean agregarCliente(Cliente nuevoCliente){
        this.clientes.add(nuevoCliente);
        return true;
    }
    public String mostrarClientes(){
        StringBuilder returnVal = new StringBuilder("____________________\n Clientes: \n");
        this.clientes.forEach(cliente -> {
            returnVal.append(cliente.toString()+'\n');
        });
        returnVal.append("_______________________");
        return returnVal.toString();
    }
    public boolean eliminarCliente(String dni){
        List<Cliente> listaNueva = this.clientes.stream().filter(c-> !c.getDni().equals(dni)).collect(Collectors.toList());

        this.setClientes(listaNueva);
        return true;
    }
    public Cliente mostrarUnCliente(String dni){

        List<Cliente> listaNueva = this.clientes.stream().filter(c-> c.getDni() == dni).collect(Collectors.toList());
        return listaNueva.size() >0 ? listaNueva.get(0) : new Cliente();
    }
    public boolean agregarItem(Item nuevoItem){
        this.items.add(nuevoItem);
        return true;
    }
    public void agregarFactura(Factura nuevaFactura){
        this.facturas.add(nuevaFactura);
    }


}
