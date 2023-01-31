package com.bootcamp.vehicles.service.accident;

import com.bootcamp.vehicles.dto.AccidentDTO;
import com.bootcamp.vehicles.dto.MessageDTO;

import java.util.List;

public interface IAccidentService {

    MessageDTO createAccident(AccidentDTO accidentDTO);
    List<AccidentDTO> getAllAccidents();
}
