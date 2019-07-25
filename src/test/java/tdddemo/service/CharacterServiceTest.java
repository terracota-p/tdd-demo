package tdddemo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import tdddemo.dto.CharacterDto;
import tdddemo.repository.CharacterRepository;

@RunWith(SpringRunner.class)
public class CharacterServiceTest {

    private CharacterRepository characterRepository = mock(CharacterRepository.class);
    private CharacterService characterService = new CharacterService(characterRepository);
    
    @Test
    public void shouldSave() {
        String name = "C1";
        CharacterDto character = new CharacterDto(name, 4, 1);
        
        // When save
        characterService.save(character);
        
        // Then stored in repository
        then(characterRepository).should().save(name, character);
    }
    
    @Test
    public void shouldRetrieveSavedCharacterByName() {
        String name = "C1";
        CharacterDto character = new CharacterDto(name, 4, 1);
        // Given I saved character with name C1
        given(characterRepository.get(name)).willReturn(character);

        // When I GET it
        CharacterDto result = characterService.getByName(name);
        
        // Then returned
        assertEquals(character, result);
    }

}
