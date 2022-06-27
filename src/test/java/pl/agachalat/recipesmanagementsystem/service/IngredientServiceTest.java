package pl.agachalat.recipesmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import pl.agachalat.recipesmanagementsystem.domain.Ingredient;
import pl.agachalat.recipesmanagementsystem.domain.MeasurementSystem;
import pl.agachalat.recipesmanagementsystem.domain.UnitOfMeasure;
import pl.agachalat.recipesmanagementsystem.exception.IngredientNotFoundException;

import java.util.List;

@SpringBootTest
@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class IngredientServiceTest {

    @Autowired
    private IngredientService ingredientService;

    @Test
    public void thatGetAllIngredientsWorks() {
        List<Ingredient> allIngredients = ingredientService.getAllIngredients();

        assertNotNull(allIngredients);
        assertFalse(allIngredients.isEmpty());
        assertEquals(3, allIngredients.size());
    }

    @Test
    public void thatGetIngredientByNameWorks() throws Exception {
        Ingredient ingredient = ingredientService.getIngredient("kurczak");

        assertNotNull(ingredient);
        assertEquals("kurczak", ingredient.getName());
        assertEquals("sztuka", ingredient.getUnitOfMeasure().getName());
        assertEquals("none", ingredient.getUnitOfMeasure().getSystem().getName());
    }

    @Test
    public void thatGetIngredientByNameThrowsException() {
        assertThrows(IngredientNotFoundException.class, () -> {
            ingredientService.getIngredient("not existing ingredient");
        });
    }

    @Test
    public void thatSaveIngredientWorks() {
        Ingredient ingredientToSave = createNewIngredient();

        ingredientToSave = ingredientService.saveOrUpdateIngredient(ingredientToSave);

        assertNotNull(ingredientToSave);
        assertNotNull(ingredientToSave.getIngId());
        assertEquals(1L, (long) ingredientToSave.getIngId());
    }

    @Test
    public void thatDeleteIngredientByNameWorks() throws Exception {
        ingredientService.deleteIngredient("kurczak");

        List<Ingredient> allIngredients = ingredientService.getAllIngredients();

        assertEquals(2, allIngredients.size());
    }

    @Test
    public void thatDeleteIngredientByNameThrowsException() {
        assertThrows(IngredientNotFoundException.class, () -> {
            ingredientService.deleteIngredient("not existing ingredient");
        });
    }

    private Ingredient createNewIngredient() {
        MeasurementSystem measurementSystem = new MeasurementSystem(1L, "metric");
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure(1L, "litr", measurementSystem);
        return new Ingredient(null, "sok", unitOfMeasure);
    }
}
