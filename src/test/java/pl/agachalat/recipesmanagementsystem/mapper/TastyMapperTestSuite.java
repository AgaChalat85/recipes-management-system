package pl.agachalat.recipesmanagementsystem.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agachalat.recipesmanagementsystem.dto.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TastyMapperTestSuite {

    @Autowired
    private TastyMapper tastyMapper;

    @Test
    void mapToTastyRecipeDtoTest() {
        //Given
        List<TastyRecipeSectionDto> tastyRecipeSectionDtoList = new ArrayList<>();
        List<TastyRecipeComponentDto> tastyRecipeComponentDtoList = new ArrayList<>();
        tastyRecipeComponentDtoList.add(new TastyRecipeComponentDto("test_ingredient"));
        tastyRecipeSectionDtoList.add(new TastyRecipeSectionDto(tastyRecipeComponentDtoList));
        List<TastyRecipeInstructionDto> recipeInstructionDtoListList = new ArrayList<>();
        recipeInstructionDtoListList.add(new TastyRecipeInstructionDto("test_instruction"));
        TastyRecipeResponseDto tastyRecipeResponseDto = new TastyRecipeResponseDto("test_recipe", "4 Servings", 35, tastyRecipeSectionDtoList,recipeInstructionDtoListList);
        //When
        TastyRecipeDto tastyRecipeDto = tastyMapper.mapToTastyRecipeDto(tastyRecipeResponseDto);
        //Then
        assertEquals("test_recipe", tastyRecipeDto.getName());
        assertEquals("4 Servings", tastyRecipeDto.getNumServings());
        assertEquals(35, tastyRecipeDto.getCookTime());
        assertEquals("test_instruction", tastyRecipeDto.getInstructionsDtoList().get(0));
        assertEquals("test_ingredient", tastyRecipeDto.getIngredientsDtoList().get(0));

    }

    @Test
    void mapToInstructionsDtoListTest() {
        //Given
        List<TastyRecipeInstructionDto> recipeInstructionDtoListList = new ArrayList<>();
        recipeInstructionDtoListList.add(new TastyRecipeInstructionDto("test_instruction"));
        //When
        List<String> instructionsList = tastyMapper.mapToInstructionsDtoList(recipeInstructionDtoListList);
        //Then
        assertEquals(1, instructionsList.size());
        assertEquals("test_instruction", instructionsList.get(0));
    }

    @Test
    void mapToIngredientsDtoListTest() {
        //Given
        List<TastyRecipeSectionDto> tastyRecipeSectionDtoList = new ArrayList<>();
        List<TastyRecipeComponentDto> tastyRecipeComponentDtoList = new ArrayList<>();
        tastyRecipeComponentDtoList.add(new TastyRecipeComponentDto("test_ingredient"));
        tastyRecipeSectionDtoList.add(new TastyRecipeSectionDto(tastyRecipeComponentDtoList));
        //When
        List<String> ingredientsListDto = tastyMapper.mapToIngredientsDtoList(tastyRecipeSectionDtoList);
        //Then
        assertEquals(1, ingredientsListDto.size());
        assertEquals("test_ingredient", ingredientsListDto.get(0));

    }
}
