package com.bootcamp.miniseries.service;

import com.bootcamp.miniseries.dto.MiniSerieDTO;
import com.bootcamp.miniseries.dto.MiniSerieWithIdDTO;
import com.bootcamp.miniseries.dto.ResultDTO;
import com.bootcamp.miniseries.model.MiniSerie;
import com.bootcamp.miniseries.repository.IMiniSerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService implements IMiniSerieService{

    private IMiniSerieRepository miniSerieRepository;
    private ModelMapper modelMapper;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
        modelMapper = new ModelMapper();
        modelMapper.typeMap(MiniSerie.class, MiniSerieWithIdDTO.class)
                .addMappings(mapper -> {
                    mapper.map(MiniSerie::getId, MiniSerieWithIdDTO::setId);
                    mapper.map(MiniSerie::getRating, (MiniSerieWithIdDTO ms, Double v) -> ms.getMiniSerieDTO().setRating(v));
                    mapper.map(MiniSerie::getAmountOfAwards, (MiniSerieWithIdDTO ms, Integer v) -> ms.getMiniSerieDTO().setAmountOfAwards(v));
                    mapper.map(MiniSerie::getName, (MiniSerieWithIdDTO ms, String v) -> ms.getMiniSerieDTO().setName(v));
                });
    }

    @Override
    public ResultDTO createSerie(MiniSerieDTO miniSerieDTO) {
        var miniSerie = modelMapper.map(miniSerieDTO, MiniSerie.class);
        var updatedMiniSerie = miniSerieRepository.save(miniSerie);
        var miniSerieWithIdDTO = modelMapper.map(updatedMiniSerie, MiniSerieWithIdDTO.class);
        return new ResultDTO("Mini serie created.", miniSerieWithIdDTO);
    }
}
