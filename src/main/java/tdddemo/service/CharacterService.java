package tdddemo.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdddemo.dto.CharacterDto;
import tdddemo.repository.CharacterRepository;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    
    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        super();
        this.characterRepository = characterRepository;
    }

    public void save(@Valid CharacterDto character) {
        characterRepository.put(character.getName(), character);
    }

    public CharacterDto getByName(String name) {
        return characterRepository.get(name);
    }

}
