package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/criar")
    public String criarGame(){
        return "Game criado!";
    }

    //GET ALL
    @GetMapping("/todos")
    public List<GameModel> mostrarTodosOsGame(){
        return gameService.listarGame();
    }

    @GetMapping("/todosID")
    public String mostrarTodosOsGamePorId(){
        return "Game Mostrado por id!";
    }

    @PutMapping("/atualizarID")
    public String atualizarGamePorId(){
        return "Atualizar Game ID";
    }

    @DeleteMapping("/deletarID")
    public String deletarGamePorId(){
        return "deletar game por id!";
    }

}
