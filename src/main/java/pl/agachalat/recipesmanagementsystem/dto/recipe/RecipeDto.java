package pl.agachalat.recipesmanagementsystem.dto.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.Instruction;
import pl.agachalat.recipesmanagementsystem.domain.Item;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RecipeDto {

    private Long rcpId;
    private String name;
    private String servingsNumber;
    private Integer cookTime;
    private List<Item> ingredientList = new ArrayList<>();
    private List<Instruction> instructions = new ArrayList<>();
    private boolean isFavourite;
}