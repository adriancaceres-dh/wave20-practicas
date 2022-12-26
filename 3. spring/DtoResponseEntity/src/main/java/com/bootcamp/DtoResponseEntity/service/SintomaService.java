package com.bootcamp.DtoResponseEntity.service;

import com.bootcamp.DtoResponseEntity.dto.SintomaDTO;
import com.bootcamp.DtoResponseEntity.model.Sintoma;
import com.bootcamp.DtoResponseEntity.repository.SintomaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public class SintomaService {
    private SintomaRepository sintomaRepository;
    public SintomaService() {
        sintomaRepository = new SintomaRepository();
    }

    public ResponseEntity<Object> listaDeSintomas(){
       List<Sintoma>sintomaList=sintomaRepository.listaDeSintoma();
       try{
           return new ResponseEntity<>(sintomaList, HttpStatus.ACCEPTED);
       }catch (Exception e){
           return  new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
       }
    }
      public ResponseEntity<Object> guardarSintoma(Sintoma sintoma){
        try {
            Sintoma sintomaEncontrado = sintomaRepository.encontrarSintoma(sintoma.getNombre());
            if(sintomaEncontrado != null)
                return new ResponseEntity<>("El sintoma " + sintomaEncontrado.getNombre() + " ya se encuentra registrado", HttpStatus.FORBIDDEN);
            sintomaRepository.guardarSintoma(sintoma);

            return  new ResponseEntity<>("Sintoma guardado correctamente",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }


    public ResponseEntity<Object> encontrarSintoma(String nombre){
        try {
            List<Sintoma> sintomaList = sintomaRepository.listaDeSintoma();
            Optional<Sintoma> sintomaEncontrado = sintomaList.stream().filter(s-> s.getNombre().equalsIgnoreCase(nombre)).findFirst();
            int nivelDegravedad = sintomaEncontrado.get().getNivelDeGravedad();
            String nombreSintoma = sintomaEncontrado.get().getNombre();
            return  new ResponseEntity<>("Nombre del sintoma: " + nombreSintoma.toUpperCase() + ". Su nivel de gravedad es: " + nivelDegravedad ,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }


}
