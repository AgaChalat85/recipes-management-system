package pl.agachalat.recipesmanagementsystem.tastyworld.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.SuggestedRecipeDto;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.TastyWorldResponseDto;
import pl.agachalat.recipesmanagementsystem.exception.SuggestedRecipesNotFoundException;
import pl.agachalat.recipesmanagementsystem.tastyworld.client.TastyWorldClient;
import pl.agachalat.recipesmanagementsystem.tastyworld.facade.TastyWorldFacade;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TastyWorldFacadeTest {

    @Autowired
    private TastyWorldFacade tastyWorldFacade;

    @Mock
    private TastyWorldClient tastyWorldClient;

    @Test
    void shouldGetSuggestedRecipesByIngredients() throws SuggestedRecipesNotFoundException {
        //Given
        List<String> ingredients = List.of("test_ingredient");
        List<String> recipeName = List.of("test_recipe");
        List<String> recipeUrl = List.of("test_recipeUrl");
        TastyWorldResponseDto tastyRecipeResponseDto = new TastyWorldResponseDto(ingredients, recipeName, recipeUrl);

        Optional<TastyWorldResponseDto> tastyWorldResponseDto = Optional.of(tastyRecipeResponseDto);

        when(tastyWorldClient.getSuggestedRecipesByIngredients(List.of("ingredient1", "ingredient2"))).thenReturn(tastyWorldResponseDto);
        tastyWorldFacade.setTastyWorldClient(tastyWorldClient);
        // When
        List<SuggestedRecipeDto> recipesByIngredients = tastyWorldFacade.getSuggestedRecipesByIngredients(List.of("ingredient1", "ingredient2"));
        // Then
        assertEquals(1, recipesByIngredients.size());
        assertEquals("test_recipe", recipesByIngredients.get(0).getRecipeName());
        assertEquals("test_recipeUrl", recipesByIngredients.get(0).getRecipeUrl());
    }

}
