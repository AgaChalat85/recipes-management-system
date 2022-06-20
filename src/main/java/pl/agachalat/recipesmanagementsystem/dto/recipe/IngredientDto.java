package pl.agachalat.recipesmanagementsystem.dto.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.dto.measure.UnitOfMeasureDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class IngredientDto {

    private Long ingId;
    private String name;
    private UnitOfMeasureDto unitOfMeasureDto;

}
