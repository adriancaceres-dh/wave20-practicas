package com.bootcamp.obras_literarias.service;

import com.bootcamp.obras_literarias.dto.MensajeDTO;
import com.bootcamp.obras_literarias.dto.ObraDTO;

import java.util.List;

public interface IObraService {

    MensajeDTO createObra(ObraDTO obraDTO);
    List<ObraDTO> getObras();
    List<ObraDTO> getObrasByAutor(String autor);
    List<ObraDTO> getObrasByPalabra(String palabra);
    List<ObraDTO> getObrasAfterPublicacion(Integer publicacion);
    List<ObraDTO> getObrasBeforePublicacion(Integer publicacion);
    List<ObraDTO> getObrasByEditorial(String editorial);
}
