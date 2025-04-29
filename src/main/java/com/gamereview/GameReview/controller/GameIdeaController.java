package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.model.GameIdeaModel;
import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.service.GameIdeaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/indicacao")
public class GameIdeaController {

    private GameIdeaService gameIdeaService;

    public GameIdeaController(GameIdeaService gameIdeaService) {
        this.gameIdeaService = gameIdeaService;
    }

    //POST
    @PostMapping("/criar")
    public ResponseEntity<GameIdeaModel> criarIndicacao(@RequestBody GameIdeaModel gameIdeaModel){
        GameIdeaModel indicacaoSalva = gameIdeaService.salvarIndicacao(gameIdeaModel);
        return ResponseEntity.ok(indicacaoSalva);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<GameIdeaModel>> listar( ){
        List<GameIdeaModel> gameIdeaModelList = gameIdeaService.listarIndicacao();
        return ResponseEntity.ok(gameIdeaModelList);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<GameIdeaModel>> listarPorID(@PathVariable Long id){
        Optional<GameIdeaModel> gameIdeaModel = gameIdeaService.listarPorID(id);
        return ResponseEntity.ok(gameIdeaModel);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<GameIdeaModel> atualizar(@RequestBody GameIdeaModel gameIdeaModel, @PathVariable Long id){
        if (gameIdeaService.listarPorID(id).isPresent()){
            GameIdeaModel gameIdeaModel1 = gameIdeaService.atualizarIndicacao(gameIdeaModel,id);
            return ResponseEntity.ok(gameIdeaModel1);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        gameIdeaService.deletarIndicacao(id);
        return ResponseEntity.noContent().build();
    }
}
