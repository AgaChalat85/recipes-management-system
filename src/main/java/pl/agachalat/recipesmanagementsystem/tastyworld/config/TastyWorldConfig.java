package pl.agachalat.recipesmanagementsystem.tastyworld.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Slf4j
public class TastyWorldConfig {

    @Value("${tastyworld.suggest.recipes.endpoint}")
    private String tastyWorldSuggestRecipesEndpoint;

    @Value("${tastyworld.host}")
    private String tastyWorldHost;
}
