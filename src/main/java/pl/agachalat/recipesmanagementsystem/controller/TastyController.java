package pl.agachalat.recipesmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeDto;
import pl.agachalat.recipesmanagementsystem.exception.TastyRecipeNotFoundException;
import pl.agachalat.recipesmanagementsystem.tasty.facade.TastyFacade;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("v1/tasty")
@CrossOrigin("*")
public class TastyController {

    private final TastyFacade tastyFacade;

    @GetMapping(value = "{id}")
    public ResponseEntity<TastyRecipeDto> getRecipeByID(@PathVariable Long id) throws TastyRecipeNotFoundException {
        return ResponseEntity.ok(tastyFacade.getRecipesByID(id));

    }

    @GetMapping ("/recipes/id/{q}")
    public ResponseEntity<List<TastyRecipeDto>> getRecipeByName(@PathVariable String q) {
        return ResponseEntity.ok(tastyFacade.getRecipesByName(q));
    }

    @GetMapping ("/recipes/tag/{tags}")
    public ResponseEntity<List<TastyRecipeDto>> getRecipeByTag(@PathVariable String tags) {
        return ResponseEntity.ok(tastyFacade.getRecipeByTag(tags));
    }
}
