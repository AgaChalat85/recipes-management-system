package pl.agachalat.recipesmanagementsystem.dto.tasty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.dto.tasty.TastyRecipeComponentDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TastyRecipeSectionDto {

    @JsonProperty("components")
    private List<TastyRecipeComponentDto>  tastyRecipeComponentDtoList;
}
