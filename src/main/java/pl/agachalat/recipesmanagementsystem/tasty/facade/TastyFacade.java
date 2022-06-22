package pl.agachalat.recipesmanagementsystem.tasty.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.agachalat.recipesmanagementsystem.dto.tasty.TastyRecipeDto;
import pl.agachalat.recipesmanagementsystem.exception.TastyRecipeNotFoundException;
import pl.agachalat.recipesmanagementsystem.mapper.TastyMapper;
import pl.agachalat.recipesmanagementsystem.tasty.client.TastyClient;

import java.util.List;

@Component
@AllArgsConstructor
public class TastyFacade {

    private TastyClient tastyClient;
    private final TastyMapper tastyMapper;

    public TastyRecipeDto getRecipeByID(Long recipesId) throws TastyRecipeNotFoundException {
        return tastyMapper.mapToTastyRecipeDto(tastyClient.getRecipeByID(recipesId).orElseThrow(TastyRecipeNotFoundException::new));
    }

    public List<TastyRecipeDto> getRecipesByName(String q) {
        return tastyMapper.mapToTastyRecipeDtoList(tastyClient.getRecipesByName(q));
    }

    public List<TastyRecipeDto> getRecipeByTag(String tag) {
        return tastyMapper.mapToTastyRecipeDtoList(tastyClient.getRecipesByTags(tag));
    }

    public void setTastyClient(TastyClient tastyClient) {
        this.tastyClient = tastyClient;
    }
}
