package com.ogabriel.minicurso.spring.consumer;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class RandomUserServiceConsumer {

    private RestTemplate restClient;

    public RandomUserServiceConsumer(){
        this.restClient = new RestTemplate();
    }

    public String getRandomUser() {
        String result = restClient.getForObject(
                "https://randomuser.me/api/",
                String.class);
        return result;
    }
}
