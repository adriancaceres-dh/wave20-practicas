package com.bootcamp.MiniSeries.service;

import com.bootcamp.MiniSeries.dto.MessageDTO;
import com.bootcamp.MiniSeries.dto.MiniSerieDTO;
import com.bootcamp.MiniSeries.entity.MiniSerie;
import com.bootcamp.MiniSeries.repositoty.IMiniSerieRepository;
import com.bootcamp.MiniSeries.service.interfaces.IMiniSeriesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiniSeriesServiceImp implements IMiniSeriesService {

    private final IMiniSerieRepository miniserieRepository;

    ModelMapper mapper = new ModelMapper();

    public MiniSeriesServiceImp(IMiniSerieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    @Override
    public MiniSerieDTO saveEntity(MiniSerieDTO miniSerieDto) {

        if( miniSerieDto.getId() != null)
            throw new RuntimeException("No se permite el envio de IDs");

        var miniSeriesEntity = mapper.map(miniSerieDto, MiniSerie.class);

        MiniSerie miniSerie2 = miniserieRepository.save(miniSeriesEntity);

        return mapper.map(miniSerie2, MiniSerieDTO.class);
    }

    @Override
    public MiniSerieDTO getEntityById(Long id) {

        var miniSerie = miniserieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró mini serie"));

        return mapper.map(miniSerie, MiniSerieDTO.class);


    }

    @Override
    public List<MiniSerieDTO> getAllEntities() {

        var list = miniserieRepository.findAll();

        return list.stream().map(
                miniSerie -> mapper.map(miniSerie, MiniSerieDTO.class))
                .collect(Collectors.toList());

    }


    @Override
    public MessageDTO deleteEntity(Long id) {

        if(miniserieRepository.existsById(id)) {
            miniserieRepository.deleteById(id);
            return MessageDTO.builder()
                    .message("Se elimino la Mini Serie con id:" + id)
                    .action("DELETE")
                    .build();
        }
        else throw new RuntimeException();
    }
}
