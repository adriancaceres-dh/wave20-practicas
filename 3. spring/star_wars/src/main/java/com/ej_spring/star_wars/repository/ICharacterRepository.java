package com.ej_spring.star_wars.repository;
import com.ej_spring.star_wars.model.Character;
import java.util.List;

public interface ICharacterRepository {

    public List<Character> characters();
}
