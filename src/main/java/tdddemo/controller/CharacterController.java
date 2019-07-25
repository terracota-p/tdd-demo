package tdddemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import tdddemo.dto.CharacterDto;
import tdddemo.service.CharacterService;

@Controller
@Slf4j
public class CharacterController {

    private CharacterService characterService;
    
    @Autowired
    public CharacterController(CharacterService characterService) {
        super();
        this.characterService = characterService;
    }

    @PostMapping("/characters")
    public ResponseEntity<CharacterDto> saveCharacter(@Valid @RequestBody CharacterDto character) {
        log.info("saveCharacter {}", character);

        characterService.save(character);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(character);
    }

    @GetMapping("/characters/{name}")
    public ResponseEntity<CharacterDto> getCharacterByName(@PathVariable String name) {
        log.info("getCharacterByName {}", name);
        
        CharacterDto character = characterService.getByName(name);
        
        return ResponseEntity.status(HttpStatus.OK).body(character);
    }
}
