package pl.agachalat.recipesmanagementsystem.dto.tasty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TastyRecipeDto {
    private String name;
    private String numServings;
    private Integer cookTime;
    private List<String> ingredientsDtoList;
    private List<String> instructionsDtoList;

}
