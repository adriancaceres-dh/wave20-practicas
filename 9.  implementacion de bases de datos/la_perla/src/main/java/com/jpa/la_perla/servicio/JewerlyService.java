package com.jpa.la_perla.servicio;


import com.jpa.la_perla.dto.JewerlyResponseCompleteDto;
import com.jpa.la_perla.dto.JewerlyResponseDto;
import com.jpa.la_perla.dto.JewerlyRequestDto;
import com.jpa.la_perla.excepcion.NotFound;
import com.jpa.la_perla.modelo.Jewerly;
import com.jpa.la_perla.repositorio.IJewerlyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class JewerlyService implements IJewerlyService {

    @Autowired
    private IJewerlyRepository jewerlyRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public JewerlyResponseDto create(JewerlyRequestDto joya) {
        joya.setVenta_o_no(true);
        Jewerly joyaCreada = jewerlyRepository.save(mapper.map(joya, Jewerly.class));
        return new JewerlyResponseDto("El número identificatorio es: "+
                joyaCreada.getId(),
                201);
    }

    @Override
    public List<Jewerly> get() {
        return jewerlyRepository.findAll().
                stream().collect(Collectors.toList());
    }

    @Override
    public String delete(Integer id) {
        if (!jewerlyRepository.existsById(id)) return "El recurso que intenta eliminar no existe";
        jewerlyRepository.deleteById(id);
        return "Recurso eliminado";
    }

    @Override
    public JewerlyResponseCompleteDto update(Integer id, JewerlyRequestDto jewerlyRequestDto) throws NotFound {
        Optional<Jewerly> maybeJewerly = jewerlyRepository.findById(id);
        if (!maybeJewerly.isPresent()) throw new NotFound(404, "No se encontró el recurso");
        Jewerly jewerly = maybeJewerly.get();
        jewerly = mapper.map(jewerlyRequestDto, Jewerly.class);
        jewerly.setId(maybeJewerly.get().getId());
        jewerly.setVenta_o_no(true);
        jewerlyRepository.save(jewerly);
        return mapper.map(jewerly, JewerlyResponseCompleteDto.class);


    }


}
