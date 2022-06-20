package pl.agachalat.recipesmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.dto.recipe.IngredientDto;
import pl.agachalat.recipesmanagementsystem.exception.IngredientNotFoundException;
import pl.agachalat.recipesmanagementsystem.mapper.IngredientMapper;
import pl.agachalat.recipesmanagementsystem.service.IngredientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/ingredients")
@CrossOrigin("*")
public class IngredientController {

    private final IngredientService ingredientService;
    private final IngredientMapper ingredientMapper;

    @GetMapping
    public ResponseEntity<List<IngredientDto>> getIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredientMapper.mapToIngredientDtoList(ingredients));
    }

    @GetMapping(value = "{ingName}")
    public ResponseEntity<IngredientDto> getIngredientByName(@PathVariable String ingName) throws IngredientNotFoundException {
        return ResponseEntity.ok(ingredientMapper.mapToIngredientDto(ingredientService.getIngredient(ingName)));

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientMapper.mapToIngredient(ingredientDto);
        ingredientService.saveOrUpdateIngredient(ingredient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{ingName}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable String ingName) throws IngredientNotFoundException {
        ingredientService.deleteIngredient(ingName);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<IngredientDto> updateIngredient(@RequestBody IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientMapper.mapToIngredient(ingredientDto);
        Ingredient addedIngredient = ingredientService.saveOrUpdateIngredient(ingredient);
        return ResponseEntity.ok(ingredientMapper.mapToIngredientDto(addedIngredient));
    }
}
