package pl.agachalat.recipesmanagementsystem.tastyworld.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.SuggestedRecipeDto;
import pl.agachalat.recipesmanagementsystem.exception.SuggestedRecipesNotFoundException;
import pl.agachalat.recipesmanagementsystem.exception.TastyRecipeNotFoundException;
import pl.agachalat.recipesmanagementsystem.mapper.TastyWorldMapper;
import pl.agachalat.recipesmanagementsystem.tastyworld.client.TastyWorldClient;

import java.util.List;

@AllArgsConstructor
@Component
public class TastyWorldFacade {

    private TastyWorldClient tastyWorldClient;
    private final TastyWorldMapper tastyWorldMapper;

    public List<SuggestedRecipeDto> getSuggestedRecipesByIngredients(List<String> ingredients) throws SuggestedRecipesNotFoundException {
        return tastyWorldMapper.mapToSuggestRecipeDto(tastyWorldClient.getSuggestedRecipesByIngredients(ingredients).orElseThrow(SuggestedRecipesNotFoundException::new));
    }

    public void setTastyWorldClient(TastyWorldClient tastyWorldClient) {
        this.tastyWorldClient = tastyWorldClient;
    }
}
