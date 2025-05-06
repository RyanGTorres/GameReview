package com.gamereview.GameReview.service;

import com.gamereview.GameReview.model.GameIdeaModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    private final WebClient webClient;
    private String apiKey = System.getenv("API_KEY");

    public ChatGptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateIdea(List<GameIdeaModel>gameIdeaModels){

        String listajogos = String.valueOf(gameIdeaModels.stream()
                .map(item -> String.format("%s (%s) - ", item.getNome(), item.getGenero(), item.getPlataformaDigital()))
                .collect(Collectors.joining("\n")))

        ;

        String prompt = "Me sugira jogos baseado no meu banco de dados, com os seguinte jogos: "+ listajogos;
        Map<String, Object> requestBody = Map.of(
            "model", "gemini-2.0-flash",
                "messages", List.of(
                        Map.of("role", "system", "content", "Você e um especialista que faz indicação de jogos para pessoas"),
                        Map.of("role", "user", "content", prompt)
                )
        );
        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer "+apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");
                    if (choices != null && !choices.isEmpty()){
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return message.get("content").toString();
                    }
                    return "Nenhum jogo foi citado.";
                });
    }


}
