package com.bootcamp.vehicles.service.accident;

import com.bootcamp.vehicles.dto.AccidentDTO;
import com.bootcamp.vehicles.dto.MessageDTO;
import com.bootcamp.vehicles.model.Accident;
import com.bootcamp.vehicles.repository.IAccidentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccidentServiceImpl implements IAccidentService {

    private final IAccidentRepository accidentRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public AccidentServiceImpl(IAccidentRepository accidentRepository) {
        this.accidentRepository = accidentRepository;

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public MessageDTO createAccident(AccidentDTO accidentDTO) {
        Accident accident = modelMapper.map(accidentDTO, Accident.class);
        accident = accidentRepository.save(accident);
        return new MessageDTO(201, "The accident was created with the following ID: " + accident.getId() + ".");
    }

    @Override
    public List<AccidentDTO> getAllAccidents() {
        List<Accident> accidents = accidentRepository.findAll();
        return accidents.stream().map(accident -> modelMapper.map(accident, AccidentDTO.class)).collect(Collectors.toList());
    }
}
