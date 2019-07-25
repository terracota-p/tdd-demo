package tdddemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import tdddemo.dto.CharacterDto;

@Controller
public class CharacterController {

    @PostMapping("/characters")
    public ResponseEntity<CharacterDto> saveCharacter(CharacterDto character) {
        return ResponseEntity.status(HttpStatus.CREATED).body(character);
    }

}
