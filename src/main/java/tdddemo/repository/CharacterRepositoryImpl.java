package tdddemo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Repository;

import tdddemo.dto.CharacterDto;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    private Map<String, CharacterDto> charactersByName = new HashMap<>();

    @Override
    public void save(String name, @Valid CharacterDto character) {
        charactersByName.put(name, character);
    }

    @Override
    public CharacterDto get(String name) {
        return charactersByName.get(name);
    }

    @Override
    public Collection<CharacterDto> listAll() {
        return charactersByName.values();
    }
}
