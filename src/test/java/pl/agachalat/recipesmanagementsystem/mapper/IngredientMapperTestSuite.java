package pl.agachalat.recipesmanagementsystem.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.domain.MeasurementSystem;
import pl.agachalat.recipesmanagementsystem.domain.UnitOfMeasure;
import pl.agachalat.recipesmanagementsystem.dto.measure.MeasurementSystemDto;
import pl.agachalat.recipesmanagementsystem.dto.measure.UnitOfMeasureDto;
import pl.agachalat.recipesmanagementsystem.dto.recipe.IngredientDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IngredientMapperTestSuite {

    @Autowired
    private IngredientMapper ingredientMapper;

    @Test
    void mapToIngredientTest() {
        //Given
        MeasurementSystemDto systemDto = new MeasurementSystemDto(1L, "metric_system");
        UnitOfMeasureDto unitOfMeasureDto = new UnitOfMeasureDto(1L, "test_unit", systemDto);
        IngredientDto ingredientDto = new IngredientDto(1L, "test_ingredient", unitOfMeasureDto);
        //When
        Ingredient ingredient = ingredientMapper.mapToIngredient(ingredientDto);
        //Then
        assertEquals(1L, ingredient.getIngId());
        assertEquals("test_ingredient", ingredient.getName());
        assertEquals("test_unit", ingredient.getUnitOfMeasure().getName());
        assertEquals("metric_system", ingredient.getUnitOfMeasure().getSystem().getName());
    }

    @Test
    void mapToIngredientDtoTest() {
        //Given
        Ingredient ingredient = createIngredientObject();
        //When
        IngredientDto ingredientDto = ingredientMapper.mapToIngredientDto(ingredient);
        //Then
        assertEquals(1L, ingredientDto.getIngId());
        assertEquals("test_ingredient", ingredientDto.getName());
        assertEquals("test_unit", ingredientDto.getUnitOfMeasureDto().getName());
        assertEquals("metric_system", ingredientDto.getUnitOfMeasureDto().getSystemDto().getName());
    }

    @Test
    void mapToIngredientDtoListTest() {
        //Given
        Ingredient ingredient = createIngredientObject();
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);
        //When
        List<IngredientDto> ingredientDtoList = ingredientMapper.mapToIngredientDtoList(ingredientList);
        //Then
        assertEquals(1, ingredientDtoList.size());
        assertEquals(1L, ingredientDtoList.get(0).getIngId());
        assertEquals("test_ingredient", ingredientDtoList.get(0).getName());
        assertEquals("test_unit", ingredientDtoList.get(0).getUnitOfMeasureDto().getName());

    }

    private Ingredient createIngredientObject() {
        MeasurementSystem system = new MeasurementSystem(1L, "metric_system");
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure(1L, "test_unit", system);
        return new Ingredient(1L, "test_ingredient", unitOfMeasure);
    }
}
