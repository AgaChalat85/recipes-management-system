package pl.agachalat.recipesmanagementsystem.tasty.facade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.agachalat.recipesmanagementsystem.dto.tasty.*;
import pl.agachalat.recipesmanagementsystem.exception.TastyRecipeNotFoundException;
import pl.agachalat.recipesmanagementsystem.tasty.client.TastyClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TastyFacadeTest {

    @Autowired
    private TastyFacade tastyFacade;

    @Mock
    private TastyClient tastyClient;

    @Test
    void shouldGetRecipesByID() throws TastyRecipeNotFoundException {
        // Given
        Optional<TastyRecipeResponseDto> tastyRecipeResponseDto = Optional.of(createTastyRecipeResponseDto());
        when(tastyClient.getRecipeByID(1L)).thenReturn(tastyRecipeResponseDto);
        tastyFacade.setTastyClient(tastyClient);
        // When
        TastyRecipeDto tastyRecipeById = tastyFacade.getRecipeByID(1L);
        // Then
        assertEquals(1, tastyRecipeById.getId());
        assertEquals("test_recipe", tastyRecipeById.getName());
        assertEquals("4 Servings", tastyRecipeById.getNumServings());
        assertEquals(35, tastyRecipeById.getCookTime());
        assertEquals("test_ingredient", tastyRecipeById.getIngredientsDtoList().get(0));
        assertEquals("test_instruction", tastyRecipeById.getInstructionsDtoList().get(0));
    }

    @Test
    void shouldGetRecipesByName() {
        // Given
        TastyRecipeResponseDto tastyRecipeResponseDto = createTastyRecipeResponseDto();
        List<TastyRecipeResponseDto> tastyRecipeList = new ArrayList<>();
        tastyRecipeList.add(tastyRecipeResponseDto);
        when(tastyClient.getRecipesByName("test_name")).thenReturn(tastyRecipeList);
        tastyFacade.setTastyClient(tastyClient);
        // When
        List<TastyRecipeDto> tastyRecipesByName = tastyFacade.getRecipesByName("test_name");
        // Then
        assertEquals(1, tastyRecipesByName.size());
        assertEquals(1, tastyRecipesByName.get(0).getId());
        assertEquals("test_recipe", tastyRecipesByName.get(0).getName());
        assertEquals("4 Servings", tastyRecipesByName.get(0).getNumServings());
        assertEquals(35, tastyRecipesByName.get(0).getCookTime());
        assertEquals("test_ingredient", tastyRecipesByName.get(0).getIngredientsDtoList().get(0));
        assertEquals("test_instruction",tastyRecipesByName.get(0).getInstructionsDtoList().get(0));
    }

    @Test
    void shouldGetRecipesByTag() {
        // Given
        TastyRecipeResponseDto tastyRecipeResponseDto = createTastyRecipeResponseDto();
        List<TastyRecipeResponseDto> tastyRecipeList = new ArrayList<>();
        tastyRecipeList.add(tastyRecipeResponseDto);
        when(tastyClient.getRecipesByTags("test_tag")).thenReturn(tastyRecipeList);
        tastyFacade.setTastyClient(tastyClient);
        // When
        List<TastyRecipeDto> tastyRecipesByTag = tastyFacade.getRecipeByTag("test_tag");
        // Then
        assertEquals(1, tastyRecipesByTag.size());
        assertEquals(1, tastyRecipesByTag.get(0).getId());
        assertEquals("test_recipe", tastyRecipesByTag.get(0).getName());
        assertEquals("4 Servings", tastyRecipesByTag.get(0).getNumServings());
        assertEquals(35, tastyRecipesByTag.get(0).getCookTime());
        assertEquals("test_ingredient", tastyRecipesByTag.get(0).getIngredientsDtoList().get(0));
        assertEquals("test_instruction",tastyRecipesByTag.get(0).getInstructionsDtoList().get(0));
    }

    private TastyRecipeResponseDto createTastyRecipeResponseDto() {
        List<TastyRecipeSectionDto> tastyRecipeSectionDtoList = new ArrayList<>();
        List<TastyRecipeComponentDto> tastyRecipeComponentDtoList = new ArrayList<>();
        tastyRecipeComponentDtoList.add(new TastyRecipeComponentDto("test_ingredient"));
        tastyRecipeSectionDtoList.add(new TastyRecipeSectionDto(tastyRecipeComponentDtoList));
        List<TastyRecipeInstructionDto> recipeInstructionDtoListList = new ArrayList<>();
        recipeInstructionDtoListList.add(new TastyRecipeInstructionDto("test_instruction"));
        return new TastyRecipeResponseDto( 1L, "test_recipe", "4 Servings",
                35, tastyRecipeSectionDtoList, recipeInstructionDtoListList);
    }
}
