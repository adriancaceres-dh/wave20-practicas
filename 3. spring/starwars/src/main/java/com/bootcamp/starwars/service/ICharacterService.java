package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.CharacterDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICharacterService {

    public List<CharacterDtoResponse> charactersThatMatch(String query);

}
