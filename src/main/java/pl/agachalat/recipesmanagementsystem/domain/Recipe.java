package pl.agachalat.recipesmanagementsystem.domain;

import java.util.List;

public class Recipe {

    private Long id;
    private String name;
    private String servingsNumber;
    private Integer cookTime;
    private List<Ingredient> ingredientList;
    //private List<Instruction> instructionList;
    private boolean isFavourite;
}
