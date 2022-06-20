package pl.agachalat.recipesmanagementsystem.controller;

import com.google.gson.Gson;
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
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.domain.System;
import pl.agachalat.recipesmanagementsystem.domain.UnitOfMeasure;
import pl.agachalat.recipesmanagementsystem.dto.measure.SystemDto;
import pl.agachalat.recipesmanagementsystem.dto.measure.UnitOfMeasureDto;
import pl.agachalat.recipesmanagementsystem.dto.recipe.IngredientDto;
import pl.agachalat.recipesmanagementsystem.mapper.IngredientMapper;
import pl.agachalat.recipesmanagementsystem.service.IngredientService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(IngredientController.class)
public class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService ingredientService;

    @MockBean
    private IngredientMapper ingredientMapper;


    @Test
    void shouldGetIngredients() throws Exception {
        //Given
        Ingredient ingredient = createIngredientObject();
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);

        IngredientDto ingredientDto = createIngredientDto();
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        ingredientDtoList.add(ingredientDto);

        when(ingredientService.getAllIngredients()).thenReturn(ingredientList);
        when(ingredientMapper.mapToIngredientDtoList(any(List.class))).thenReturn(ingredientDtoList);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/ingredients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200)).andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ingId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is("test_ingredient")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].unitOfMeasureDto.name", Matchers.is("test_unit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].unitOfMeasureDto.systemDto.name", Matchers.is("metric_system")));

    }

    @Test
    void shouldGetIngredient() throws Exception {
        //Given
        Ingredient ingredient = createIngredientObject();
        IngredientDto ingredientDto = createIngredientDto();

        when(ingredientService.getIngredient("test_ingredient")).thenReturn(ingredient);
        when(ingredientMapper.mapToIngredientDto(ingredient)).thenReturn(ingredientDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/ingredients/test_ingredient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ingId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("test_ingredient")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.unitOfMeasureDto.uomId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.unitOfMeasureDto.name", Matchers.is("test_unit")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.unitOfMeasureDto.systemDto.sysId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.unitOfMeasureDto.systemDto.name", Matchers.is("metric_system")));
    }

    @Test
    void shouldAddIngredient() throws Exception {
        //Given
        IngredientDto ingredientDto = createIngredientDto();

        Gson gson = new Gson();
        String jsonContent = gson.toJson(ingredientDto);

        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void shouldDeleteIngredient() throws Exception {
        //Given
        Ingredient ingredient = createIngredientObject();
        when(ingredientService.getIngredient("test_ingredient")).thenReturn(ingredient);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/ingredients/test_ingredient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void shouldUpdateIngredient() throws Exception {
        //Given
        Ingredient ingredient = createIngredientObject();
        IngredientDto ingredientDto = createIngredientDto();

        when(ingredientMapper.mapToIngredient(any(IngredientDto.class))).thenReturn(ingredient);
        when(ingredientService.saveOrUpdateIngredient(ingredient)).thenReturn(ingredient);
        when(ingredientMapper.mapToIngredientDto(ingredient)).thenReturn(ingredientDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(ingredientDto);
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/v1/ingredients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8").content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ingId", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("test_ingredient")));
    }

    private Ingredient createIngredientObject() {
        System system = new System(1L, "metric_system");
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure(1L, "test_unit", system);
        return new Ingredient(1L, "test_ingredient", unitOfMeasure);
    }

    private IngredientDto createIngredientDto() {
        SystemDto systemDto = new SystemDto(1L, "metric_system");
        UnitOfMeasureDto unitOfMeasureDto = new UnitOfMeasureDto(1L, "test_unit", systemDto);
        return new IngredientDto(1L, "test_ingredient", unitOfMeasureDto);
    }

}
