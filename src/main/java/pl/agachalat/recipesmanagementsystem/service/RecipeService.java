package pl.agachalat.recipesmanagementsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.domain.Recipe;
import pl.agachalat.recipesmanagementsystem.exception.RecipeNotFoundException;
import pl.agachalat.recipesmanagementsystem.exception.UserNotFoundException;
import pl.agachalat.recipesmanagementsystem.repository.RecipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes(final Long userId) throws UserNotFoundException {
        return recipeRepository.findAllByUser(userId).orElseThrow(UserNotFoundException::new);

    }

    public boolean deleteRecipe(final Long userId, final Long recipeId)  {
       return recipeRepository.deleteByUserAndRcpId(userId, recipeId);
    }

    public boolean deleteAllRecipe(final Long userId) {
        return recipeRepository.deleteAllByUser(userId);
    }

    public Recipe getRecipe(Long userId, Long recipeId) throws RecipeNotFoundException {
        return recipeRepository.findByUserAndRcpId(userId,recipeId).orElseThrow(RecipeNotFoundException::new);
    }

    public Recipe saveRecipe(Recipe recipe) {
      return recipeRepository.save(recipe);
    }

}
