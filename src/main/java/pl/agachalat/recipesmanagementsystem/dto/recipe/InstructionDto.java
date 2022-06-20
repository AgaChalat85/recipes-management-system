package pl.agachalat.recipesmanagementsystem.dto.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.Recipe;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InstructionDto {

    private Long insId;
    private String description;
    private RecipeDto recipeDto;
}
