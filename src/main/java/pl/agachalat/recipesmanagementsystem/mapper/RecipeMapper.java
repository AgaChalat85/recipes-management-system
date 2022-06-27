package pl.agachalat.recipesmanagementsystem.mapper;

import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.domain.Instruction;
import pl.agachalat.recipesmanagementsystem.domain.Item;
import pl.agachalat.recipesmanagementsystem.domain.Recipe;
import pl.agachalat.recipesmanagementsystem.dto.recipe.InstructionDto;
import pl.agachalat.recipesmanagementsystem.dto.recipe.ItemDto;
import pl.agachalat.recipesmanagementsystem.dto.recipe.RecipeDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeMapper {

    private IngredientMapper ingredientMapper;
    private UserMapper userMapper;

    public RecipeDto mapToRecipeDto(final Recipe recipe) {
        return new RecipeDto(
                recipe.getRcpId(),
                recipe.getName(),
                recipe.getServingsNumber(),
                recipe.getCookTime(),
                mapToIngredientDtoList(recipe.getIngredientList()),
                mapToInstructionDto(recipe.getInstructions()),
                recipe.isFavourite(),
                userMapper.mapToUserDto(recipe.getUser())
                );
    }

    public Recipe mapToRecipe(final RecipeDto recipeDto) {
        return new Recipe(
                recipeDto.getRcpId(),
                recipeDto.getName(),
                recipeDto.getServingsNumber(),
                recipeDto.getCookTime(),
                mapToIngredientList(recipeDto.getIngredientDtoList()),
                mapToInstructionList(recipeDto.getInstructionsDtoList()),
                recipeDto.isFavourite(),
                userMapper.mapToUser(recipeDto.getUserDto())
        );
    }

    public List<RecipeDto> mapToRecipeDtoList(final List<Recipe> recipeList) {
        return recipeList.stream()
                .map(this::mapToRecipeDto)
                .collect(Collectors.toList());
    }

    public List<Recipe> mapToRecipeList(final List<RecipeDto> recipeDtoList) {
        return recipeDtoList.stream()
                .map(this::mapToRecipe)
                .collect(Collectors.toList());
    }

    public List<ItemDto> mapToIngredientDtoList(final List<Item> ingredientList) {
        return ingredientList.stream()
                .map(this::mapToItemDto)
                .collect(Collectors.toList());
    }

    public List<Item> mapToIngredientList(final List<ItemDto> itemDtoList) {
        return itemDtoList.stream()
                .map(this::mapToItem)
                .collect(Collectors.toList());
    }

    private List<InstructionDto> mapToInstructionDto(final List<Instruction> instructionList) {
        return instructionList.stream()
                .map(this:: mapToInstructionDto)
                .collect(Collectors.toList());
    }

    private List<Instruction> mapToInstructionList(final List<InstructionDto> instructionDtoList) {
        return instructionDtoList.stream()
                .map(this:: mapToInstruction)
                .collect(Collectors.toList());
    }

    private ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getItmId(),
                ingredientMapper.mapToIngredientDto(item.getIngredient()),
                item.getQuantity(),
                item.getUser(),
                mapToRecipeDto(item.getRecipe())
        );
    }

    private Item mapToItem(ItemDto itemDto) {
        return new Item(
                itemDto.getItmId(),
                ingredientMapper.mapToIngredient(itemDto.getIngredientDto()),
                itemDto.getQuantity(),
                itemDto.getUser(),
                mapToRecipe(itemDto.getRecipeDto())
        );
    }

    private InstructionDto mapToInstructionDto(final Instruction instruction) {
        return new InstructionDto(
                instruction.getInsId(),
                instruction.getDescription(),
                mapToRecipeDto(instruction.getRecipe())
        );
    }

    private Instruction mapToInstruction(final InstructionDto instructionDto) {
        return new Instruction(
                instructionDto.getInsId(),
                instructionDto.getDescription(),
                mapToRecipe(instructionDto.getRecipeDto())
        );
    }

}
