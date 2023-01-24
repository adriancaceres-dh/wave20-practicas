package com.example.Joyeria_Las_Perlas.services;

import com.example.Joyeria_Las_Perlas.DTO.AllJoyasResponseDto;
import com.example.Joyeria_Las_Perlas.DTO.JoyaCreatedDto;
import com.example.Joyeria_Las_Perlas.DTO.JoyaDto;
import com.example.Joyeria_Las_Perlas.model.Joya;
import com.example.Joyeria_Las_Perlas.repositories.IJoyasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyeriaService implements IJoyeriaService{

    private final IJoyasRepository repoJoyas;

    public JoyeriaService(IJoyasRepository newRepo) {
        repoJoyas = newRepo;
    }

    @Override
    public AllJoyasResponseDto getJoyas() {
        List<Joya> joyas = repoJoyas.findAll();
        return new AllJoyasResponseDto(joyas.stream().map(x->mapJoyaToJoyaDto(x)).collect(Collectors.toList()));
    }

    @Override
    public JoyaCreatedDto saveJoya(JoyaDto newJoya) {
        // Verificar porque no agarra el atributo "venta_o_no".
        repoJoyas.save(mapJoyaDtoToJoya(newJoya));
        // Se debería buscar mejor pero a eventos prácticos pasa...
        Optional<Joya> joyaSavedBD = repoJoyas.findAll().stream().filter(x->x.getNombre().equals(newJoya.getNombre())).collect(Collectors.toList()).stream().findFirst();
        if (joyaSavedBD.isPresent()){
            return new JoyaCreatedDto(joyaSavedBD.get().getNro_identificatorio());
        }
        return new JoyaCreatedDto(0);
    }

    private Joya mapJoyaDtoToJoya(JoyaDto joyaDto){
        Joya joya = new Joya();
        joya.setNro_identificatorio(joyaDto.getNro_identificatorio());
        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPosee_piedra(joyaDto.getPosee_piedra());
        joya.setVentaONo(joyaDto.getVentaONo());
        return joya;
    }
    private JoyaDto mapJoyaToJoyaDto(Joya joya){
        JoyaDto joyaDto = new JoyaDto(
                joya.getNro_identificatorio(),
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.getPosee_piedra(),
                joya.getVentaONo());
        return joyaDto;
    }

    @Override
    public Boolean deleteJoya(Integer id) {
        return null;
    }

    @Override
    public JoyaDto findJoya(Integer id) {
        return null;
    }
}
