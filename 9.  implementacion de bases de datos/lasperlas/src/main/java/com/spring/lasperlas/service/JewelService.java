package com.spring.lasperlas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.lasperlas.dto.MessageDTO;
import com.spring.lasperlas.dto.request.JewelRequestDTO;
import com.spring.lasperlas.dto.response.JewelListedDTO;
import com.spring.lasperlas.dto.response.JewelResponseDTO;
import com.spring.lasperlas.exception.JewelAlreadyDeletedException;
import com.spring.lasperlas.exception.JewelNotFoundException;
import com.spring.lasperlas.model.Jewel;
import com.spring.lasperlas.respository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelService implements IJewelService{
    IJewelRepository jewelRepository;
    public JewelService(IJewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }
    private ModelMapper mapper = new ModelMapper();

    @Override
    public MessageDTO createJewel(JewelRequestDTO jewelRequestDTO) {
        Jewel jewelToCreate = mapper.map(jewelRequestDTO, Jewel.class);
        Jewel created = jewelRepository.save(jewelToCreate);
        return MessageDTO.builder().message(created.getId().toString()).build();
    }

    @Override
    public JewelListedDTO getJewerly() {
        List<Jewel> jewerly = jewelRepository.findAll();
        List<JewelResponseDTO> jewelResponseDTOList = jewerly.stream()
                .filter(Jewel::getForSale)
                .map(jewel -> mapper.map(jewel, JewelResponseDTO.class))
                .collect(Collectors.toList());
        return JewelListedDTO.builder().jewerly(jewelResponseDTOList).build();
    }

    @Override
    public MessageDTO deleteJewelLogically(Long id) {
        Jewel jewelToDelete = jewelRepository.findById(id).orElseThrow(() -> {return new JewelNotFoundException("Joya no encontrada");});
        if(!jewelToDelete.getForSale()) throw new JewelAlreadyDeletedException("La joya ya fue eliminada.");
        jewelToDelete.setForSale(false);
        jewelRepository.save(jewelToDelete);
        return MessageDTO.builder().message("Joya eliminada.").build();
    }
}
