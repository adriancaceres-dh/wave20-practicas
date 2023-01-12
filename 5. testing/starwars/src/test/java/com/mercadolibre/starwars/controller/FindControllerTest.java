package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
  @Mock
  private FindService findServiceMock;

  @InjectMocks
  private FindController findController;

  @Test
  void testFind() {
    //arrange
    CharacterDTO characterDTO = CharacterDTO.builder()
            .name("Luke Skywalker")
            .hair_color("blond")
            .birth_year("19BBY")
            .eye_color("")
            .species("Human")
            .mass(77)
            .gender("male")
            .height(172)
            .homeworld("")
            .skin_color("fair")
            .build();
    when(findServiceMock.find("Luke")).thenReturn(List.of(characterDTO));
    //act
    List<CharacterDTO> result = findController.find("Luke");

    //assert
    assertEquals(1, result.size());
    assertEquals(characterDTO.getName(), result.get(0).getName());
    assertEquals(characterDTO.getHair_color(), result.get(0).getHair_color());
    assertEquals(characterDTO.getBirth_year(), result.get(0).getBirth_year());
    assertEquals(characterDTO.getEye_color(), result.get(0).getEye_color());
    assertEquals(characterDTO.getSpecies(), result.get(0).getSpecies());
    assertEquals(characterDTO.getMass(), result.get(0).getMass());
    assertEquals(characterDTO.getGender(), result.get(0).getGender());
    assertEquals(characterDTO.getHeight(), result.get(0).getHeight());
    assertEquals(characterDTO.getHomeworld(), result.get(0).getHomeworld());
    assertEquals(characterDTO.getSkin_color(), result.get(0).getSkin_color());    verify(findServiceMock, times(1)).find("Luke");
  }

}
