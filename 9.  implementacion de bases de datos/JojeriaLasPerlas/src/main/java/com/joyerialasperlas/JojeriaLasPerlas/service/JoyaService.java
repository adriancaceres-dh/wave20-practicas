package com.joyerialasperlas.JojeriaLasPerlas.service;

import com.joyerialasperlas.JojeriaLasPerlas.model.Joya;
import com.joyerialasperlas.JojeriaLasPerlas.repository.IJoyaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JoyaService implements IJoyaService{
    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public void saveJoya(Joya joya) {
        joyaRepository.save(joya);
    }

    @Override
    public void deleteJoya(Long id) {
        joyaRepository.deleteById(id);
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
    public Joya updateJoya(Long id, Joya joyaNueva) {
        Joya actual = joyaRepository.findById(id).orElse(null);

        actual.setNombre(joyaNueva.getNombre());
        actual.setMaterial(joyaNueva.getMaterial());
        actual.setPeso(joyaNueva.getPeso());
        actual.setParticularidad(joyaNueva.getParticularidad());
        actual.setPosee_piedra(joyaNueva.getPosee_piedra());
        actual.setVentaONo(joyaNueva.getVentaONo());

        this.saveJoya(actual);
        return actual;
    }
}
