package pl.agachalat.recipesmanagementsystem.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agachalat.recipesmanagementsystem.dto.tasty.TastyRecipeDto;
import pl.agachalat.recipesmanagementsystem.dto.tasty.TastyRecipeResponseDto;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.SuggestedRecipeDto;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.TastyWorldResponseDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TastyWorldMapperTestSuite {

    @Autowired
    private TastyWorldMapper tastyWorldMapper;

    @Test
    void mapToSuggestRecipeDtoTest() {
        //Given
        List<String> ingredients = List.of("test_ingredient");
        List<String> recipeName = List.of("test_recipe");
        List<String> recipeUrl = List.of("test_recipeUrl");

        TastyWorldResponseDto tastyRecipeResponseDto = new TastyWorldResponseDto(ingredients, recipeName, recipeUrl);

        //When
        List<SuggestedRecipeDto> suggestedRecipeDtoList = tastyWorldMapper.mapToSuggestRecipeDto(tastyRecipeResponseDto);
        //Then
        assertEquals(1, suggestedRecipeDtoList.size());
        assertEquals("test_recipe", suggestedRecipeDtoList.get(0).getRecipeName());
        assertEquals("test_recipeUrl", suggestedRecipeDtoList.get(0).getRecipeUrl());
    }

}
