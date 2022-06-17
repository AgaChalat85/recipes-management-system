package pl.agachalat.recipesmanagementsystem.dto.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.domain.Recipe;
import pl.agachalat.recipesmanagementsystem.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDto {

    private Long itmId;
    private Ingredient ingredient;
    private Double quantity;
    private User user;
    private Recipe recipe;
}
