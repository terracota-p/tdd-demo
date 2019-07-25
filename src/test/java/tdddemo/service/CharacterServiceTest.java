package tdddemo.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import tdddemo.dto.CharacterDto;
import tdddemo.repository.CharacterRepository;
import tdddemo.repository.CharacterRepositoryImpl;

@RunWith(SpringRunner.class)
public class CharacterServiceTest {

    private CharacterRepository characterRepository = new CharacterRepositoryImpl();
    private CharacterService characterService = new CharacterService(characterRepository);
    
    @Test
    public void shouldRetrieveSavedCharacterByName() {
        String name = "C1";
        CharacterDto character = new CharacterDto(name, 4, 1);
        // Given I saved character with name C1
        characterService.save(character);

        // When I GET it
        CharacterDto result = characterService.getByName(name);
        
        // Then returned
        assertEquals(character, result);
    }

}
