package pl.agachalat.recipesmanagementsystem.tasty.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class TastyConfig {

    @Value("${tasty.api.endpoint.prod}")
    private String tastyApiEndpoint;

    @Value("${tasty.api.recipes.get.more.info.endpoint}")
    private String tastyApiRecipesGetMoreInfoEndpoint;

    @Value("${tasty.api.recipes.list.endpoint}")
    private String tastyApiRecipesGetListByName;

    @Value("${tasty.header.host}")
    private String tastyHeaderHost;

    @Value("${tasty.host}")
    private String tastyHost;

    @Value("${tasty.header.key}")
    private String tastyHeaderKey;

    @Value("${tasty.key}")
    private String tastyKey;

}
