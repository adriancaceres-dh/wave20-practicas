package com.joyeria.lasperlas.service;

import com.joyeria.lasperlas.model.Joya;
import com.joyeria.lasperlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public String addJoya(Joya joya) {
        joyaRepository.save(joya);

       return "Joya agregada correctamente";
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
    public String inactivateJoya(Long id) {

        Joya joyaADesactivar = this.findJoya(id);
        joyaADesactivar.setVentaONo(false);
        this.addJoya(joyaADesactivar);

        return "Joya cambiada de estado a inactiva";
    }

    @Override
    public String editJoya(Long id, Joya joyaModificada) {

        Joya joyaOriginal = this.findJoya(id);

        joyaOriginal.setNombre(joyaModificada.getNombre());
        joyaOriginal.setMaterial(joyaModificada.getMaterial());
        joyaOriginal.setPeso(joyaModificada.getPeso());
        joyaOriginal.setParticularidad(joyaModificada.getParticularidad());
        joyaOriginal.setPosee_piedra(joyaModificada.isPosee_piedra());
        joyaOriginal.setVentaONo(joyaModificada.isVentaONo());

        this.addJoya(joyaOriginal);
        return "Joya modificada correctamente";

    }
}
