package pl.agachalat.recipesmanagementsystem.mapper;

import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.domain.User;
import pl.agachalat.recipesmanagementsystem.dto.user.UserDto;

@Service
public class UserMapper {

    private RecipeMapper recipeMapper;

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUsrId(),
                userDto.getName(),
                userDto.getEMail(),
                userDto.getPassword(),
                recipeMapper.mapToIngredientList(userDto.getItemsDto()),
                recipeMapper.mapToRecipeList(userDto.getRecipeDtoList())
        );
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUsrId(),
                user.getName(),
                user.getEMail(),
                user.getPassword(),
                recipeMapper.mapToIngredientDtoList(user.getItems()),
                recipeMapper.mapToRecipeDtoList(user.getRecipes())
        );
    }

}
