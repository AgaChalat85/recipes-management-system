package pl.agachalat.recipesmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.agachalat.recipesmanagementsystem.domain.Recipe;
import pl.agachalat.recipesmanagementsystem.dto.recipe.RecipeDto;
import pl.agachalat.recipesmanagementsystem.exception.RecipeNotFoundException;
import pl.agachalat.recipesmanagementsystem.exception.UserNotFoundException;
import pl.agachalat.recipesmanagementsystem.mapper.RecipeMapper;
import pl.agachalat.recipesmanagementsystem.service.RecipeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/recipes")
@CrossOrigin("*")
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    @GetMapping(value = "{userId}")
    public ResponseEntity<List<RecipeDto>> getRecipes(@PathVariable Long userId) throws UserNotFoundException {
        List<Recipe> recipeList = recipeService.getAllRecipes(userId);
        return ResponseEntity.ok(recipeMapper.mapToRecipeDtoList(recipeList));
    }

    @GetMapping(value = "/getRecipe/{userId}/{recipeId}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long userId, @PathVariable Long recipeId) throws UserNotFoundException, RecipeNotFoundException {
        Recipe recipe = recipeService.getRecipe(userId, recipeId);
        return ResponseEntity.ok(recipeMapper.mapToRecipeDto(recipe));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRecipe(@RequestBody RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.mapToRecipe(recipeDto);
        recipeService.saveRecipe(recipe);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RecipeDto> updateRecipe(@RequestBody RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.mapToRecipe(recipeDto);
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        return ResponseEntity.ok(recipeMapper.mapToRecipeDto(savedRecipe));
    }

    @DeleteMapping(value = "/deleteRecipe/{userId}/{recipeId}")
    public ResponseEntity<Boolean> deleteRecipe(@PathVariable Long userId, @PathVariable Long recipeId) {
        boolean removed = recipeService.deleteRecipe(userId,recipeId);
        return ResponseEntity.ok(removed);
    }

    @DeleteMapping(value = "/deleteAllRecipe/{userId}")
    public ResponseEntity<Boolean> deleteAllRecipe(@PathVariable Long userId) {
        boolean removed = recipeService.deleteAllRecipe(userId);
        return ResponseEntity.ok(removed);
    }


}
