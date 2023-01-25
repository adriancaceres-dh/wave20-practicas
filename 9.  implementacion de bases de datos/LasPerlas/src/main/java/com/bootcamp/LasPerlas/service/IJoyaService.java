package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JoyaDTO;
import com.bootcamp.LasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    public List<JoyaDTO> getAllJewels();

    public JoyaDTO findJewel(Integer id);

    public String saveJewel(JoyaDTO joyaDTO);

    public JoyaDTO updateJewel(JoyaDTO joyaDTO, Integer id_modificar);

    public String deleteJewel(Integer id);

}
