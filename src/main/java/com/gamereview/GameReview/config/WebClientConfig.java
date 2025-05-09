package com.gamereview.GameReview.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${chatgpt.api.url:https://generativelanguage.googleapis.com/v1beta/openai/chat/completions}")
    private String chatGptApiUrl;

    @Bean
    public WebClient webClient (WebClient.Builder builder){
        return builder.baseUrl(chatGptApiUrl).build();
    }
}
