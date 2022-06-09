package pl.agachalat.recipesmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TastyRecipeDto {

    private String name;

    @JsonProperty("yields")
    private String numServings;

    @JsonProperty("cook_time_minutes")
    private Integer cookTime;

    @JsonProperty("sections")
    private List<SectionsDto> sections;

    private List<InstructionsDto> instructions;

}
