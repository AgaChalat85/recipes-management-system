package pl.agachalat.recipesmanagementsystem.dto.tastyworld;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TastyWorldResponseDto {

    private List<String> ingredients;
    @JsonProperty("recipe_name")
    private List<String> recipeName;
    @JsonProperty("recipe_url")
    private List<String> recipeUrl;
}
