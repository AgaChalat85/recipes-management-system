package pl.agachalat.recipesmanagementsystem.mapper;

import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.SuggestedRecipeDto;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.TastyWorldResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class TastyWorldMapper {
    public List<SuggestedRecipeDto> mapToSuggestRecipeDto(final TastyWorldResponseDto tastyWorldDto) {
        List<SuggestedRecipeDto> suggestedRecipeDtoList = new ArrayList<>();
        for (int i = 0; i < tastyWorldDto.getRecipeUrl().size(); i++) {
            String name = tastyWorldDto.getRecipeName().get(i);
            String url = tastyWorldDto.getRecipeUrl().get(i);
            suggestedRecipeDtoList.add(new SuggestedRecipeDto(name, url));
        }
        return suggestedRecipeDtoList;
    }
}
