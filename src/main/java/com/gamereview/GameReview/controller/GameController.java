package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.dto.GameDTO;
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
    public GameDTO criarGame(@RequestBody GameDTO game){
        return gameService.criarGame(game);
    }

    //GET ALL
    @GetMapping("/listar")
    public List<GameModel> mostrarTodosOsGame(){
        return gameService.listarGame();
    }

    @GetMapping("/listar/{id}")
    public GameModel listarGameporID(@PathVariable Long id){
        return gameService.listarGamePorID(id);
    }

    @PutMapping("/atualizar/{id}")
    public GameModel atualizarGame(@PathVariable Long id, @RequestBody GameModel gameAtualizado){
        return gameService.atualizarGame(id, gameAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarGamePorId(@PathVariable Long id){
        gameService.deletarGame(id);
    }

}
