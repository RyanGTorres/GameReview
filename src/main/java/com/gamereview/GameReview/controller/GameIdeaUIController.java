package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.model.GameIdeaModel;
import com.gamereview.GameReview.service.GameIdeaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ui")
public class GameIdeaUIController {

    private final GameIdeaService gameIdeaService;

    public GameIdeaUIController(GameIdeaService gameIdeaService) {
        this.gameIdeaService = gameIdeaService;
    }

    @GetMapping
    public String exibirFormulario(Model model) {
        model.addAttribute("gameIdeaModel", new GameIdeaModel());
        model.addAttribute("listaJogos", gameIdeaService.listarIndicacao());
        return "game-idea";
    }

    @PostMapping("/salvar")
    public String salvarJogo(@ModelAttribute GameIdeaModel gameIdeaModel) {
        gameIdeaService.salvarIndicacao(gameIdeaModel);
        return "redirect:/ui";
    }

    @GetMapping("/deletar/{id}")
    public String deletarJogo(@PathVariable Long id) {
        gameIdeaService.deletarIndicacao(id);
        return "redirect:/ui";
    }

}