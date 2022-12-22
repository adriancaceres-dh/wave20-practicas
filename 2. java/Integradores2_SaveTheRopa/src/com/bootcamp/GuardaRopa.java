package com.bootcamp;

import java.util.*;

public class GuardaRopa {


    private int identificador;
    private Map<Integer, List<Prenda>> prendas;

    // si se devuelve una prenda su numero de identificador queda vacante
    private Queue<Integer> identificadoresVacantes ;

    public GuardaRopa(){
        this.identificador = 0;
        this.prendas =  new HashMap<>();
        this.identificadoresVacantes = new LinkedList<>();
    }

    public Integer obtenerIdentificador(){
        if (identificadoresVacantes.size() > 0) return identificadoresVacantes.remove();
        return ++identificador;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        int identificador = obtenerIdentificador();
        prendas.put(identificador,listaDePrendas);
        return identificador;
    }

    public void mostrarPrendas(){
        System.out.println(prendas);
    }

    public void validarIdentificador(int identificador) throws Exception {
        if (prendas.get(identificador) == null)
            throw new Exception("No hay elementos en GuardaRopa con el identificador " +identificador);
    }


    public List<Prenda> devolverPrendas(int identificador) {
        try{
            validarIdentificador(identificador);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        List<Prenda> prendaADevolver = prendas.get(identificador);
        prendas.remove(identificador);
        identificadoresVacantes.add(identificador);
        return(prendaADevolver);
    }
}
