package pl.agachalat.recipesmanagementsystem.tasty.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.agachalat.recipesmanagementsystem.dto.TastyRecipeResponseDto;
import pl.agachalat.recipesmanagementsystem.dto.TastyResultsResponseDto;
import pl.agachalat.recipesmanagementsystem.enums.TagsEnum;
import pl.agachalat.recipesmanagementsystem.enums.UrlParameterEnum;
import pl.agachalat.recipesmanagementsystem.tasty.config.TastyConfig;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class TastyClient {

    private final RestTemplate restTemplate;
    private final TastyConfig tastyConfig;
    private final HttpEntity tastyEntity;

    public TastyClient(RestTemplate restTemplate, TastyConfig tastyConfig, HttpEntity tastyEntity) {
        this.restTemplate = restTemplate;
        this.tastyConfig = tastyConfig;
        this.tastyEntity = tastyEntity;
    }

    public Optional<TastyRecipeResponseDto> getRecipesByID(Long id) {
        URI url = UriComponentsBuilder.fromHttpUrl(tastyConfig.getTastyApiRecipesGetMoreInfoEndpoint())
                .queryParam(UrlParameterEnum.ID.getValue(), id)
                .build().encode().toUri();

        TastyRecipeResponseDto response = restTemplate.exchange(url, HttpMethod.GET, tastyEntity, TastyRecipeResponseDto.class).getBody();

        try {
            log.info("Request Successful.");
            return Optional.of(response);

        } catch (RestClientException e) {
            log.info("Request Failed");
            return Optional.empty();
        }

    }

    public List<TastyRecipeResponseDto> getRecipesByName(String name) {

        URI url = UriComponentsBuilder.fromHttpUrl(tastyConfig.getTastyApiRecipesGetListByName())
                .queryParam("from", 0)
                .queryParam("size", 20)
                .queryParam(UrlParameterEnum.Q.getValue(), name)
                .build().encode().toUri();

        TastyResultsResponseDto response = restTemplate.exchange(url, HttpMethod.GET, tastyEntity, TastyResultsResponseDto.class).getBody();

        try {
            log.info("Request Successful.");
            return response.getRecipeDtoList();
        } catch (RestClientException e) {
            log.info("Request Failed");
            return new ArrayList<>();
        }
    }

    public List<TastyRecipeResponseDto> getRecipesByTags(String tag) {

        URI url = UriComponentsBuilder.fromHttpUrl(tastyConfig.getTastyApiRecipesGetListByName())
                .queryParam("from", 0)
                .queryParam("size", 20)
                .queryParam("tags", tag)
                .build().encode().toUri();

        TastyResultsResponseDto response = restTemplate.exchange(url, HttpMethod.GET, tastyEntity, TastyResultsResponseDto.class).getBody();

        try {
            log.info("Request Successful.");
            return response.getRecipeDtoList();
        } catch (RestClientException e) {
            log.info("Request Failed");
            return new ArrayList<>();
        }
    }

}
