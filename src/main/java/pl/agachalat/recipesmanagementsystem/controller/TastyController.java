package pl.agachalat.recipesmanagementsystem.controller;

import org.springframework.web.bind.annotation.*;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeResponseDto;
import pl.agachalat.recipesmanagementsystem.service.TastyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/tasty")
@CrossOrigin("*")
public class TastyController {

    private final TastyService tastyService;

    public TastyController(TastyService tastyService) {
        this.tastyService = tastyService;
    }

    @GetMapping(value = "{id}")
    public TastyRecipeResponseDto getRecipeByID(@PathVariable Long id) {
        Optional<TastyRecipeResponseDto> recipe = tastyService.getRecipesByID(id);
        return recipe.isPresent() ? recipe.get() : null;

    }

    @GetMapping ("/recipes/{q}")
    public List<TastyRecipeResponseDto> getRecipeByName(@PathVariable String q) {
        return tastyService.getRecipesByName(q);
    }

    @GetMapping ("/recipes/tag/{tags}")
    public List<TastyRecipeResponseDto> getRecipeByTag(@PathVariable String tags) {

        return tastyService.getRecipesByName(tags);
    }
}
