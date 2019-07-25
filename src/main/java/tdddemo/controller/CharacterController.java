package tdddemo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import tdddemo.dto.CharacterDto;

@Controller
@Slf4j
public class CharacterController {

    @PostMapping("/characters")
    public ResponseEntity<CharacterDto> saveCharacter(@Valid CharacterDto character) {
        log.info("saveCharacter {}", character);
        return ResponseEntity.status(HttpStatus.CREATED).body(character);
    }

}
