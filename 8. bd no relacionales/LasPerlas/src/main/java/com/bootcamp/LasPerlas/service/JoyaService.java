package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JoyaDTO;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<JoyaDTO> getAllJewels() {
        var list = joyaRepository.findAll();

        return list.stream()
                .filter(Joya::getVentaONo)
                .map(joya -> mapper.map(joya, JoyaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JoyaDTO findJewel(Integer id) {
        var joya = joyaRepository.findById(id);

        return mapper.map(joya, JoyaDTO.class);
    }

    @Override
    public String saveJewel(JoyaDTO joyaDTO) {
        var joya = mapper.map(joyaDTO, Joya.class);

        joya.setVentaONo(true);

        joya = joyaRepository.save(joya);

        return "El número identificatorio es: " + joya.getId();
    }

    @Override
    public JoyaDTO updateJewel(JoyaDTO joyaDTO, Integer id_modificar) {
        if(joyaRepository.existsById(id_modificar)) {
            //joyaRepository.deleteById(id);
            Joya joya = mapper.map(joyaDTO, Joya.class);

            joya.setId(id_modificar);

            joya = joyaRepository.save(joya);

            return mapper.map(joya, JoyaDTO.class);
        }
        else throw new RuntimeException();
    }

    @Override
    public String deleteJewel(Integer id) {
        if(joyaRepository.existsById(id)) {
            //joyaRepository.deleteById(id);
            var joya = joyaRepository.findById(id).get();

            joya.setVentaONo(false);

            joya = joyaRepository.save(joya);

            return "Se eliminó la joya con id:" + id;
        }
        else throw new RuntimeException();
    }
}
