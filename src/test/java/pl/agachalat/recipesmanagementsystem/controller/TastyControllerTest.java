package pl.agachalat.recipesmanagementsystem.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.agachalat.recipesmanagementsystem.dto.tasty.TastyRecipeDto;
import pl.agachalat.recipesmanagementsystem.tasty.facade.TastyFacade;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TastyController.class)
public class TastyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TastyFacade tastyFacade;

    @Test
    void shouldGetRecipeByID() throws Exception {
        //Given
        TastyRecipeDto tastyRecipeDto = createTastyRecipeDto();
        when(tastyFacade.getRecipeByID(1L)).thenReturn(tastyRecipeDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tasty/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("test_recipe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numServings", Matchers.is("4 Servings")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cookTime", Matchers.is(35)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ingredientsDtoList[0]", Matchers.is("test_ingredient")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.instructionsDtoList[0]", Matchers.is("test_instruction")));
    }

    @Test
    void shouldGetRecipeByName() throws Exception {
        //Given
        TastyRecipeDto tastyRecipeDto = createTastyRecipeDto();
        List<TastyRecipeDto> tastyRecipeDtoList = List.of(tastyRecipeDto);
        when(tastyFacade.getRecipesByName("test_name")).thenReturn(tastyRecipeDtoList);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tasty/recipes/id/test_name")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("test_recipe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].numServings", Matchers.is("4 Servings")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cookTime", Matchers.is(35)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ingredientsDtoList[0]", Matchers.is("test_ingredient")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].instructionsDtoList[0]", Matchers.is("test_instruction")));
    }

    @Test
    void shouldGetRecipeByTag() throws Exception {
        //Given
        TastyRecipeDto tastyRecipeDto = createTastyRecipeDto();
        List<TastyRecipeDto> tastyRecipeDtoList = List.of(tastyRecipeDto);
        when(tastyFacade.getRecipeByTag("test_tag")).thenReturn(tastyRecipeDtoList);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tasty/recipes/tag/test_tag")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("test_recipe")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].numServings", Matchers.is("4 Servings")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cookTime", Matchers.is(35)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ingredientsDtoList[0]", Matchers.is("test_ingredient")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].instructionsDtoList[0]", Matchers.is("test_instruction")));
    }

    private TastyRecipeDto createTastyRecipeDto() {
        List<String> ingredientsDtoList = List.of("test_ingredient");
        List<String> instructionsDtoList = List.of("test_instruction");
        return new TastyRecipeDto(1L, "test_recipe", "4 Servings", 35, ingredientsDtoList, instructionsDtoList);
    }

}


