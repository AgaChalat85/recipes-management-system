package pl.agachalat.recipesmanagementsystem.tastyworld.client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.agachalat.recipesmanagementsystem.dto.tastyworld.TastyWorldResponseDto;
import pl.agachalat.recipesmanagementsystem.enums.UrlParameterEnum;
import pl.agachalat.recipesmanagementsystem.tastyworld.config.TastyWorldConfig;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class TastyWorldClient {

    private final RestTemplate restTemplate;
    private final TastyWorldConfig tastyWorldConfig;
    @Qualifier("tastyWorldEntity")
    private final HttpEntity tastyWorldEntity;

    public Optional<TastyWorldResponseDto> getSuggestRecipesByIngredients(List<String> ingredients) {

        final String ingredientsURLPart = String.join(",", ingredients);
        URI url = UriComponentsBuilder.fromHttpUrl(tastyWorldConfig.getTastyWorldSuggestRecipesEndpoint())
                .queryParam(UrlParameterEnum.INGREDIENTS.getValue(), ingredientsURLPart)
                .build().encode().toUri();

        ResponseEntity<TastyWorldResponseDto> response = restTemplate.exchange(url, HttpMethod.GET, tastyWorldEntity, TastyWorldResponseDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            log.info("Request Successful.");
            return Optional.of(response.getBody());
        } else {
            log.info("Request Failed");
            return Optional.empty();
        }
    }
}
