package pl.agachalat.recipesmanagementsystem.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeDto;
import pl.agachalat.recipesmanagementsystem.enums.TagsEnum;
import pl.agachalat.recipesmanagementsystem.tasty.client.TastyClient;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TastyService {

    private final TastyClient tastyClient;

    public Optional<TastyRecipeDto> getRecipesByID(Long recipesId) {
        return tastyClient.getRecipesByID(recipesId);
    }

    public List<TastyRecipeDto> getRecipesByName(String q) {
        return tastyClient.getRecipesByName(q);
    }

    public List<TastyRecipeDto> getRecipeByTag(TagsEnum tag) {
        return tastyClient.getRecipesByTags(tag);
    }
}
