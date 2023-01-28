package com.example.JoyeriaLasPerlas.service;

import com.example.JoyeriaLasPerlas.model.Joya;
import com.example.JoyeriaLasPerlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JoyaService implements IJoyaService{
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    IJoyaRepository joyaRepository;

    @Override
    public String saveJoya(Joya joya) {
        joyaRepository.save(joya);
        return "Joya guardada correctamente";
    }

    @Override
    public List<Joya> getJoyas() {

        return joyaRepository.findAll();
    }

    @Override
    public Joya findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteJoya(Long id) {
        var joya = this.findJoya(id);
        joya.setVentaONo(false);
        this.saveJoya(joya);
        return "Joya eliminada correctamente";
    }

    @Override
    public String editJoya(Joya joyaNueva, Long id) {
        var joyaOriginal = this.findJoya(id);
        joyaOriginal.setNombre(joyaNueva.getNombre());
        joyaOriginal.setMaterial(joyaNueva.getMaterial());
        joyaOriginal.setPeso(joyaNueva.getPeso());
        joyaOriginal.setPoseePiedra(joyaNueva.isPoseePiedra());
        joyaOriginal.setVentaONo(joyaNueva.isVentaONo());
        this.saveJoya(joyaOriginal);
        return "Joya editada correctamente";
    }
}
