package pl.agachalat.recipesmanagementsystem.dto.recipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.Instruction;
import pl.agachalat.recipesmanagementsystem.domain.Item;
import pl.agachalat.recipesmanagementsystem.domain.User;
import pl.agachalat.recipesmanagementsystem.dto.user.UserDto;

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
    private List<ItemDto> ingredientDtoList = new ArrayList<>();
    private List<InstructionDto> instructionsDtoList = new ArrayList<>();
    private boolean isFavourite;
    private UserDto userDto;
}
