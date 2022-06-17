package pl.agachalat.recipesmanagementsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.repository.IngredientRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();

    }

    public void deleteIngredient(String ingName) {
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredient(String ingName) {
        return ingredientRepository.findByName(ingName);
    }
}