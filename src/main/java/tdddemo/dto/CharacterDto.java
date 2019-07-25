package tdddemo.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterDto {
    @NotBlank
    private String name;
    private int leadership;
    private int endurance;
}
