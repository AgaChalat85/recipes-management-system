package pl.agachalat.recipesmanagementsystem.mapper;

import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.dto.recipe.IngredientDto;

import java.util.List;
import java.util.stream.Collectors;

//
@Service
public class IngredientMapper {

    public Ingredient mapToIngredient(final IngredientDto ingredientDto) {
        return new Ingredient(
                ingredientDto.getIngId(),
                ingredientDto.getName(),
                ingredientDto.getUnitOfMeasure()
        );
    }

    public IngredientDto mapToIngredientDto(final Ingredient ingredient) {
        return new IngredientDto(
                ingredient.getIngId(),
                ingredient.getName(),
                ingredient.getUnitOfMeasure()
        );
    }

    public List<IngredientDto> mapToIngredientDtoList(final List<Ingredient> ingredientList) {
        return ingredientList.stream()
                .map(this::mapToIngredientDto)
                .collect(Collectors.toList());
    }
}
