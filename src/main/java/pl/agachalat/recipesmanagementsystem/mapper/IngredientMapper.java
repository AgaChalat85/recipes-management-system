package pl.agachalat.recipesmanagementsystem.mapper;

import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.domain.System;
import pl.agachalat.recipesmanagementsystem.domain.UnitOfMeasure;
import pl.agachalat.recipesmanagementsystem.dto.measure.SystemDto;
import pl.agachalat.recipesmanagementsystem.dto.measure.UnitOfMeasureDto;
import pl.agachalat.recipesmanagementsystem.dto.recipe.IngredientDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientMapper {

    public Ingredient mapToIngredient(final IngredientDto ingredientDto) {
        return new Ingredient(
                ingredientDto.getIngId(),
                ingredientDto.getName(),
                mapToUnitOfMeasure(ingredientDto.getUnitOfMeasureDto())
        );
    }

    public IngredientDto mapToIngredientDto(final Ingredient ingredient) {
        return new IngredientDto(
                ingredient.getIngId(),
                ingredient.getName(),
               mapToUnitOfMeasureDto(ingredient.getUnitOfMeasure())
        );
    }

    public List<IngredientDto> mapToIngredientDtoList(final List<Ingredient> ingredientList) {
        return ingredientList.stream()
                .map(this::mapToIngredientDto)
                .collect(Collectors.toList());
    }

    private UnitOfMeasure mapToUnitOfMeasure(final UnitOfMeasureDto unitOfMeasureDto) {
        return new UnitOfMeasure(
                unitOfMeasureDto.getUomId(),
                unitOfMeasureDto.getName(),
                mapToSystem(unitOfMeasureDto.getSystemDto())
        );
    }

   private System mapToSystem(final SystemDto systemDto) {
        return new System(
                systemDto.getSysId(),
                systemDto.getName()
        );
    }


    private UnitOfMeasureDto mapToUnitOfMeasureDto(final UnitOfMeasure unitOfMeasure) {
        return new UnitOfMeasureDto(
                unitOfMeasure.getUomId(),
                unitOfMeasure.getName(),
                mapToSystemDto(unitOfMeasure.getSystem())
        );
    }

    private SystemDto mapToSystemDto(final System system) {
        return new SystemDto(
                system.getSysId(),
                system.getName()
        );
    }

}
