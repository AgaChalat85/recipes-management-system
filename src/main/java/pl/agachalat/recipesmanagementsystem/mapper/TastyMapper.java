package pl.agachalat.recipesmanagementsystem.mapper;

import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.dto.tasty.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class TastyMapper {

    public TastyRecipeDto mapToTastyRecipeDto(TastyRecipeResponseDto tastyRecipeResponseDto) {
        return new TastyRecipeDto(
                tastyRecipeResponseDto.getName(),
                tastyRecipeResponseDto.getNumServings(),
                tastyRecipeResponseDto.getCookTime(),
                mapToIngredientsDtoList(tastyRecipeResponseDto.getTastyRecipeSectionDtoList()),
                mapToInstructionsDtoList(tastyRecipeResponseDto.getTastyRecipeInstructionDtoList())
        );

    }

    public List<TastyRecipeDto> mapToTastyRecipeDtoList(final List<TastyRecipeResponseDto> tastyRecipeResponseDtoList) {
        return tastyRecipeResponseDtoList.stream()
                .map(this::mapToTastyRecipeDto)
                .collect(Collectors.toList());
    }

    public List<String> mapToIngredientsDtoList(final List<TastyRecipeSectionDto> tastyRecipeSectionDtoList) {
        return tastyRecipeSectionDtoList.stream()
                .flatMap(sectionsList -> sectionsList.getTastyRecipeComponentDtoList().stream())
                .map(TastyRecipeComponentDto::getIngredient)
                .collect(toList());

    }

    public List<String> mapToInstructionsDtoList(final List<TastyRecipeInstructionDto> tastyRecipeInstructionDtoList) {
        return tastyRecipeInstructionDtoList.stream()
                .map(TastyRecipeInstructionDto::getDescription)
                .collect(toList());

    }
}