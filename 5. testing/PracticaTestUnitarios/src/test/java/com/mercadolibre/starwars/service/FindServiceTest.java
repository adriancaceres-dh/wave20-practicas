package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;
    @Test
    public void findTest(){
        String query = "dark";

        findService.find(query);

        verify(characterRepository, atLeast(1)).findAllByNameContains(query);
    }
}
