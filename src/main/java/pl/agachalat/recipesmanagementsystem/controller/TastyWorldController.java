package pl.agachalat.recipesmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.SuggestedRecipeDto;
import pl.agachalat.recipesmanagementsystem.exception.SuggestedRecipesNotFoundException;
import pl.agachalat.recipesmanagementsystem.tastyworld.facade.TastyWorldFacade;

import java.util.List;

@RestController
@RequestMapping("v1/tastyworld")
@CrossOrigin("*")
@AllArgsConstructor
public class TastyWorldController {

   private final TastyWorldFacade tastyWorldFacade;

    @GetMapping("{ingredients}")
    public ResponseEntity<List<SuggestedRecipeDto>> getSuggestedRecipesByIngredients(@PathVariable List<String> ingredients) throws SuggestedRecipesNotFoundException {
        return ResponseEntity.ok(tastyWorldFacade.getSuggestedRecipesByIngredients(ingredients));

    }
}
