package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.model.GameIdeaModel;
import com.gamereview.GameReview.service.ChatGptService;
import com.gamereview.GameReview.service.GameIdeaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class IdeaController {

    private GameIdeaService service;
    private ChatGptService chatGptService;

    public IdeaController(GameIdeaService service, ChatGptService chatGptService) {
        this.service = service;
        this.chatGptService = chatGptService;
    }

    @GetMapping("/indicacaojogo")
    public Mono<ResponseEntity<String>> generateIdea(){
        List<GameIdeaModel> gameIdea = service.listarIndicacao();
        return chatGptService.generateIdea(gameIdea)
                .map(recipe -> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
