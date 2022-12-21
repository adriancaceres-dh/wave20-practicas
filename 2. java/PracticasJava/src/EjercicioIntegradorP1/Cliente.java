package EjercicioIntegradorP1;

import java.util.Arrays;
import java.util.List;

public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private List<Factura> facturaList;

    public Cliente() {
    }
    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(int dni, String nombre, String apellido, List<Factura> facturaList) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.facturaList = facturaList;
    }

    public static void removerCliente(List<Cliente> clienteList, Cliente cliente) {
        System.out.println("-------Se ah eliminado el cliente correctamente------");
    clienteList.remove(cliente);
    clienteList.forEach(v-> System.out.println(v.getNombre() + " " + v.getDni()));
    }
    public static void buscarCliente(List<Cliente>clienteList, int dni){
        boolean existeCliente = clienteList.stream().anyMatch(cliente1 -> cliente1.getDni() == dni);
       if(existeCliente){
            clienteList.stream().filter(cliente -> cliente.getDni() == dni).forEach(v-> System.out.println("Cliente: "+ v.getNombre() +" " + v.getApellido()));
        }else {
            System.out.println("No se encontro el cliente solicitado");
        }
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }
}
