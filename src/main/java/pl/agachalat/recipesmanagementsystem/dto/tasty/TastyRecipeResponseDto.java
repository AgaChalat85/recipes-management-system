package pl.agachalat.recipesmanagementsystem.dto.tasty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TastyRecipeResponseDto {

    private String name;

    @JsonProperty("yields")
    private String numServings;

    @JsonProperty("cook_time_minutes")
    private Integer cookTime;

    @JsonProperty("sections")
    private List<TastyRecipeSectionDto> tastyRecipeSectionDtoList;
    @JsonProperty("instructions")
    private List<TastyRecipeInstructionDto> tastyRecipeInstructionDtoList;

}
