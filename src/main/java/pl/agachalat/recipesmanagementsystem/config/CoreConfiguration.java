package pl.agachalat.recipesmanagementsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import pl.agachalat.recipesmanagementsystem.tasty.config.TastyConfig;
import pl.agachalat.recipesmanagementsystem.tastyworld.config.TastyWorldConfig;

import java.util.Collections;

@Configuration
public class CoreConfiguration {

    @Autowired
    private TastyConfig tastyConfig;

    @Autowired
    private TastyWorldConfig tastyWorldConfig;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpEntity tastyEntity() {
        final HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set(tastyConfig.getTastyHeaderHost(), tastyConfig.getTastyHost());
        headers.set(tastyConfig.getTastyHeaderKey(), tastyConfig.getTastyKey());

        return new HttpEntity(headers);
    }

    @Bean
    public HttpEntity tastyWorldEntity() {
        final HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set(tastyConfig.getTastyHeaderHost(), tastyWorldConfig.getTastyWorldHost());
        headers.set(tastyConfig.getTastyHeaderKey(), tastyConfig.getTastyKey());

        return new HttpEntity(headers);
    }
}
