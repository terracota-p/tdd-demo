package tdddemo.service;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import tdddemo.dto.CharacterDto;

@Service
public class CharacterService {

    private Map<String, CharacterDto> charactersRepository = new HashMap<>();

    public void save(@Valid CharacterDto character) {
        charactersRepository.put(character.getName(), character);
    }

    public CharacterDto getByName(String name) {
        return charactersRepository.get(name);
    }

}
