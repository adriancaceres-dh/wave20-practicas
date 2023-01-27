package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.JewelDTO;
import com.bootcamp.joyeria.dto.MessageDTO;
import com.bootcamp.joyeria.dto.UpdatedDTO;
import com.bootcamp.joyeria.entity.Jewel;

import java.util.List;

public interface IJewelService {

    MessageDTO addJewel(JewelDTO jewelDTO);

    List<JewelDTO> getJewerly();

    MessageDTO deleteJewl(Integer nroIdentificatorio);

    Object updateJewel(Integer id, JewelDTO jewelDTO);
}
