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
    public List<GameDTO> mostrarTodosOsGame(){
        return gameService.listarGame();
    }

    @GetMapping("/listar/{id}")
    public GameDTO listarGameporID(@PathVariable Long id){
        return gameService.listarGamePorID(id);
    }

    @PutMapping("/atualizar/{id}")
    public GameDTO atualizarGame(@PathVariable Long id, @RequestBody GameDTO gameAtualizado){
        return gameService.atualizarGame(id, gameAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarGamePorId(@PathVariable Long id){
        gameService.deletarGame(id);
    }

}
