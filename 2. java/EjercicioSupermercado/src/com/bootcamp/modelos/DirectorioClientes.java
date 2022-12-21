package com.bootcamp.modelos;

import java.util.ArrayList;
import java.util.List;

public class DirectorioClientes implements CRUD<Cliente> {

    List<Cliente> directorio;

    public DirectorioClientes(){
        directorio = new ArrayList<>();
    }

    public DirectorioClientes(List<Cliente> directorio) {
        this.directorio = directorio;
    }

    public List<Cliente> getDirectorio() {
        return directorio;
    }

    public void setDirectorio(List<Cliente> directorio) {
        this.directorio = directorio;
    }

    public DirectorioClientes addCliente(Cliente nuevoCliente){
        this.directorio.add(nuevoCliente);
        return this;
    }

    public boolean existeCliente(Cliente nuevoCliente){
        return this.directorio.stream().anyMatch(cliente -> cliente.getDni().equals(nuevoCliente.getDni()));
    }

    @Override
    public boolean crear(Cliente elementoNuevo){
        try{
            if(!existeCliente(elementoNuevo)) {
                this.directorio.add(elementoNuevo);
                return true;
            }

            return false;
        }
        catch (Exception e){
            System.out.println("Error al intentar agregar  un nuevo cliente"+e.getMessage());
            return false;
        }
    }
    @Override
    public Cliente buscar(List<Cliente> listaOriginal, String elementoABuscar) {
        return this.directorio.stream().filter(cliente -> cliente.getDni()
                .equals(elementoABuscar))
                .findFirst().get();
    }

    @Override
    public boolean remover( String elementoARemover) {
        Cliente clienteEncontrado = buscar(this.directorio,elementoARemover);
        if(clienteEncontrado != null){
            this.directorio.remove(clienteEncontrado);
            return true;
        }
        return false;
    }

    @Override
    public boolean modificar( Cliente elementoAModificar) {
        for (Cliente cliente: this.directorio) {
            if (cliente.getDni().equals(elementoAModificar.getDni())){
                cliente.setNombre(elementoAModificar.getNombre());
                cliente.setApellido(elementoAModificar.getApellido());
                return true;
            }
        }
        return false;
    }
}
