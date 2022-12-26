package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.response.CharacterDtoResponse;

import java.util.List;

public interface ICharacterService {

    public List<CharacterDtoResponse> charactersThatMatch(String query);

}
