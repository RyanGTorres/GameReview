package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.dto.GameDTO;
import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Cria um novo jogo", description = "Essa rota cria um jogo e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "201",description = "Jogo foi criado com sucesso"),
            @ApiResponse (responseCode = "400",description = "Erro na criação do jogo")
    })
    public ResponseEntity<String> criarGame(
            @Parameter(description = "Usuario insere os dados do jogo para serem criados no corpo da requisição!")
            @RequestBody GameDTO game){
        GameDTO gameDTO = gameService.criarGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body("O Game foi criado com sucesso! \n Nome:" + gameDTO.getName() + "ID: (ID) "+gameDTO.getId());
    }

    //GET ALL
    @GetMapping("/listar")
    @Operation(summary = "Lista todos os jogos", description = "Essa rota tem a funçao de listar todos jogo e exibir essa lista")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "Mostra todas a lista de jogo!"),
    })
    public ResponseEntity<List<GameDTO>> mostrarTodosOsGame(){
        List<GameDTO> gameDTO = gameService.listarGame();
        return ResponseEntity.ok(gameDTO);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o jogo pelo seu ID", description = "Essa rota tem a funçao de listar o jogo pelo id e mostrar ao usuario")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "Jogo foi encontrado com sucesso!"),
            @ApiResponse (responseCode = "404",description = "Jogo não foi encontrado!")
    })
    public ResponseEntity<?> listarGamePorID(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id) {
        GameDTO gameDTO = gameService.listarGamePorID(id);
        if (gameDTO != null) {
            return ResponseEntity.ok(gameDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id "+id+" do jogo não foi encontrado!");
        }
    }


    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza o jogo pelo seu ID", description = "Essa rota tem a funçao de alterar o jogo pelo id")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "Jogo foi alterado com sucesso!"),
            @ApiResponse (responseCode = "404",description = "Jogo não foi alterado!")
    })
    public ResponseEntity<String> atualizarGame(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario insere os dados do jogo para ser atualizado no corpo da requisição!")
            @RequestBody GameDTO gameAtualizado) {
        if (gameService.listarGamePorID(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ID digitado não foi encontrado! ID: " + id);
        }
        GameDTO gameDTO = gameService.atualizarGame(id, gameAtualizado);
        return ResponseEntity.ok("O jogo foi atualizado com sucesso! \nNome: " + gameDTO.getName() + " ID: " + gameDTO.getId());
    }


    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta o jogo pelo seu ID", description = "Essa rota tem a funçao de deletar o jogo pelo id digitado")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "Jogo foi deletado com sucesso!"),
            @ApiResponse (responseCode = "404",description = "Jogo não foi deletado!")
    })
    public ResponseEntity<String> deletarGamePorId(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id){
        if (gameService.listarGamePorID(id) != null){
            gameService.deletarGame(id);
            return ResponseEntity.ok("O jogo foi deletado com sucesso!  ID: (ID) "+ id);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id: "+id+" não foi encontrado! ");
        }
    }

}
