package com.example.lasperlas.service;

import com.example.lasperlas.dto.ActionResponseDTO;
import com.example.lasperlas.dto.JoyaRequestDTO;
import com.example.lasperlas.dto.JoyaResponseDTO;
import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.IJoyeriaRepository;
import com.example.lasperlas.utilities.Action;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaService implements IJoyeriaService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final IJoyeriaRepository joyeriaRepository;

  public JoyeriaService(IJoyeriaRepository joyeriaRepository) {
    this.joyeriaRepository = joyeriaRepository;
  }

  @Override
  public ActionResponseDTO newJewelry(JoyaRequestDTO dto) {
    Joya joya = modelMapper.map(dto, Joya.class);
    joyeriaRepository.save(joya);
    return ActionResponseDTO.builder()
            .action(Action.ADDED)
            .nroId(joya.getId())
            .build();
  }

  @Override
  public List<JoyaResponseDTO> getAllJewelry() {
    return joyeriaRepository.findAll().stream()
            .filter(Joya::isVentaONo) //solo las joyas que están en venta, no devuelve las eliminadas lógicamente
            .map(joya -> modelMapper.map(joya, JoyaResponseDTO.class))
            .toList();
  }

  @Override
  public ActionResponseDTO deleteJewelry(Integer id) {
    Joya joya = joyeriaRepository.findById(id).orElseThrow();
    joya.setVentaONo(false);
    joyeriaRepository.save(joya);
    return ActionResponseDTO.builder()
            .action(Action.DELETED)
            .nroId(joya.getId())
            .build();
  }

  @Override
  public ActionResponseDTO updateJewelry(Integer id, JoyaRequestDTO dto) {
    Joya joya = joyeriaRepository.findById(id).orElseThrow();
    joya.setNombre(dto.getNombre());
    joya.setPeso(dto.getPeso());
    joya.setMaterial(dto.getMaterial());
    joya.setParticularidad(dto.getParticularidad());
    joya.setTienePiedra(dto.isTienePiedra());
    joyeriaRepository.save(joya);
    return ActionResponseDTO.builder()
            .action(Action.UPDATED)
            .nroId(joya.getId())
            .build();
  }
}
