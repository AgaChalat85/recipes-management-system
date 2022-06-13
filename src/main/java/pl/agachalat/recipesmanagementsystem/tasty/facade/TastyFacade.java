package pl.agachalat.recipesmanagementsystem.tasty.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeDto;
import pl.agachalat.recipesmanagementsystem.exception.TastyRecipeNotFoundException;
import pl.agachalat.recipesmanagementsystem.mapper.TastyMapper;
import pl.agachalat.recipesmanagementsystem.tasty.client.TastyClient;

import java.util.List;

@Component
@AllArgsConstructor
public class TastyFacade {

    private final TastyClient tastyClient;
    private final TastyMapper tastyMapper;

    public TastyRecipeDto getRecipesByID(Long recipesId) throws TastyRecipeNotFoundException {
        return tastyMapper.mapToTastyRecipeDto(tastyClient.getRecipesByID(recipesId).orElseThrow(TastyRecipeNotFoundException::new));
    }

    public List<TastyRecipeDto> getRecipesByName(String q) {
        return tastyMapper.mapToTastyRecipeDtoList(tastyClient.getRecipesByName(q));
    }

    public List<TastyRecipeDto> getRecipeByTag(String tag) {
        return tastyMapper.mapToTastyRecipeDtoList(tastyClient.getRecipesByTags(tag));
    }
}
