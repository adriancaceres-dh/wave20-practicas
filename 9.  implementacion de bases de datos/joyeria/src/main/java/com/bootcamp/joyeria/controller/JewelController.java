package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.JewelDTO;
import com.bootcamp.joyeria.dto.MessageDTO;
import com.bootcamp.joyeria.dto.UpdatedDTO;
import com.bootcamp.joyeria.service.IJewelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelController {

    private final IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("jewerly/new")
    public MessageDTO addJewel(@RequestBody JewelDTO jewelDTO){
        return jewelService.addJewel(jewelDTO);
    }

    @GetMapping("jewerly")
    public List<JewelDTO> getAllJewerly(){
        return jewelService.getJewerly();
    }

    @DeleteMapping("jewerly/delete/{id}")
    public MessageDTO deleteJewelById(@PathVariable Integer id){
        return jewelService.deleteJewl(id);
    }

    @PostMapping("jewerly/update/{id}")
    public Object updateJewel(@PathVariable Integer id, @RequestBody JewelDTO jewelDTO){
        return jewelService.updateJewel(id, jewelDTO);
    }
}
