package com.bootcamp.Hospital.service;

import com.bootcamp.Hospital.model.Sintoma;
import com.bootcamp.Hospital.repository.SintomaRepository;
import com.bootcamp.Hospital.response.ResponseEntity;

import java.util.List;

public class SintomaService {

    private SintomaRepository sintomaRepository;

    public SintomaService(){
        sintomaRepository = new SintomaRepository();
    }

    public ResponseEntity<Sintoma> saveSymptom(Sintoma sintoma){
        try {
            Sintoma sintomaEncontrado = sintomaRepository.findSymptom(sintoma.getNombre());
            if(sintomaEncontrado != null) return new ResponseEntity<Sintoma>(
                    "El sintoma ya se encuentra registrado", false, sintomaEncontrado);

            return  new ResponseEntity<Sintoma>("Sintoma guardado correctamente", false, sintomaRepository.saveSymptom(sintoma));
        }catch (Exception e){
            return new ResponseEntity<Sintoma>(e.getMessage(), true, null);
        }
    }

    public ResponseEntity<List<Sintoma>> findAllSymptom(){
        try {
            List<Sintoma> sintomas = sintomaRepository.findAllSymptom();
            return new ResponseEntity<List<Sintoma>>("Consulta realizada con exito", false, sintomas);
        }catch (Exception e){
            return  new ResponseEntity<List<Sintoma>>(e.getMessage(), true, null);
        }
    }

    public ResponseEntity<Sintoma> findSymptom(String nombre){
        try {
            Sintoma sintoma = sintomaRepository.findSymptom(nombre);
            if(sintoma == null) return new ResponseEntity<Sintoma>("Sintoma no encontrado", false, sintoma);
            return new ResponseEntity<Sintoma>("Sintoma encontrado", false, sintoma);
        }catch (Exception e){
            return  new ResponseEntity<Sintoma>(e.getMessage(), true, null);
        }
    }

}
