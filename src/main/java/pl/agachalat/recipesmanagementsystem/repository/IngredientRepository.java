package pl.agachalat.recipesmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {

    @Override
    List<Ingredient> findAll();

    Optional<Ingredient> findByName(String ingName);

}
