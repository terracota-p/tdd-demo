package tdddemo.repository;

import javax.validation.Valid;

import tdddemo.dto.CharacterDto;

public interface CharacterRepository {

    void put(String name, @Valid CharacterDto character);

    CharacterDto get(String name);

}