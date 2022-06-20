package pl.agachalat.recipesmanagementsystem.dto.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDto {

    private Long itmId;
    private IngredientDto ingredientDto;
    private Double quantity;
    private User user;
    private RecipeDto recipeDto;
}
