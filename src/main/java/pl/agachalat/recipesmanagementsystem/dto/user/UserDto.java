package pl.agachalat.recipesmanagementsystem.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agachalat.recipesmanagementsystem.domain.Item;
import pl.agachalat.recipesmanagementsystem.domain.Recipe;
import pl.agachalat.recipesmanagementsystem.dto.recipe.ItemDto;
import pl.agachalat.recipesmanagementsystem.dto.recipe.RecipeDto;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {

    private Long usrId;
    private String name;
    private String eMail;
    private String password;
    private List<ItemDto> itemsDto = new ArrayList<>();
    private List<RecipeDto> recipeDtoList = new ArrayList<>();
}
