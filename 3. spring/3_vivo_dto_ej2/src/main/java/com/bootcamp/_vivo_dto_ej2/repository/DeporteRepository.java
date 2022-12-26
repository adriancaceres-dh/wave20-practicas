package com.bootcamp._vivo_dto_ej2.repository;


import com.bootcamp._vivo_dto_ej2.model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteRepository {

    private static List<Deporte> listaDeportes = new ArrayList<>();

    public static boolean addDeporte(Deporte deporte){
        listaDeportes.add(deporte);
        return true;
    }

    public static Deporte getDeporte(int pos){
        return listaDeportes.get(pos);
    }

    public static Deporte getDeporteByName(String nombre){
        return listaDeportes.stream()
                .filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst().orElse(null);
    }

    public static boolean existeDeporte(String nombre){
        return listaDeportes.stream()
                .filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst().orElse(null)!=null;
    }

    public static List<Deporte> getAll(){
        return listaDeportes;
    }

    public static String getDeporteNameByID(Long id) {
        try {
            return listaDeportes.stream()
                    .filter(deporte -> deporte.getId() == id)
                    .findFirst().orElse(null).getNombre();
        } catch (Exception e) {
            return null;
        }
    }

}
