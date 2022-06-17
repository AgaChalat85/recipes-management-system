package pl.agachalat.recipesmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {

    @Override
    List<Ingredient> findAll();

    Ingredient findByName(String ingName);

}
