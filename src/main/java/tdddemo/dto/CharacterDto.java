package tdddemo.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CharacterDto {
    @NotBlank
    private String name;
    private int leadership;
    private int endurance;
}
