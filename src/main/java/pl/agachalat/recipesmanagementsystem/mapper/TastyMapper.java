package pl.agachalat.recipesmanagementsystem.mapper;

import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeDto;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeInstructionDto;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeResponseDto;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeSectionDto;

import java.util.List;

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

    public List<String> mapToIngredientsDtoList(final List<TastyRecipeSectionDto> tastyRecipeSectionDtoList) {
        return tastyRecipeSectionDtoList.stream()
                .flatMap(sectionsList -> sectionsList.getTastyRecipeComponentDtoList().stream())
                .map(componentList -> componentList.getIngredient())
                .collect(toList());

    }

    public List<String> mapToInstructionsDtoList(final List<TastyRecipeInstructionDto> tastyRecipeInstructionDtoList) {
        return tastyRecipeInstructionDtoList.stream()
                .map(instructionList -> instructionList.getDescription())
                .collect(toList());

    }
}
