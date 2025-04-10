package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.dto.RatingDTO;
import com.gamereview.GameReview.service.RatingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {
    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma avaliação", description = "Essa rota cria avaliação para ser associada e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Sua avaliação foi registrada com sucesso!"),
            @ApiResponse (responseCode = "400",description = "Erro ao registrar sua avaliação!")
    })
    public ResponseEntity<String> criarRating(
            @Parameter(description = "Usuario insere os dados da avaliação para serem criados no corpo da requisição!")
            @RequestBody RatingDTO rating){
        RatingDTO ratingDTO = ratingService.criarRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sua avaliação foi adicionada com sucesso! ID: (ID) "+ratingDTO.getId());
    }

    //GET ALL
    @GetMapping("/listar")
    @Operation(summary = "Lista todos as avaliações criadas", description = "Essa rota tem a funçao de listar todas as avaliações e exibir essa lista")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "Mostra todas a lista de avaliação!")
    })
    public ResponseEntity<List<RatingDTO>> listarRating(){
         List<RatingDTO> ratingDTO = ratingService.listarRating();
         return ResponseEntity.ok(ratingDTO);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um avaliação pelo seu ID", description = "Essa rota tem a funçao de listar uma avaliação pelo id e mostrar ao usuario")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "A avaliação foi encontrada com sucesso!"),
            @ApiResponse (responseCode = "404",description = "A avaliação não foi encontrada!")
    })
    public ResponseEntity<?> listarRatingPorID(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id){
        RatingDTO ratingDTO = ratingService.listarRatingPorID(id);
        if (ratingDTO != null){
            return ResponseEntity.ok(ratingDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id "+id+" da avaliação não foi encontrado!");
        }
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza a avaliação pelo seu ID", description = "Essa rota tem a funçao de alterar a avaliação pelo id")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "A avaliação foi alterada com sucesso!"),
            @ApiResponse (responseCode = "404",description = "A avaliação não foi alterado!")
    })
    public ResponseEntity<String> atualizarRatingPorId(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario insere os dados da avaliação para ser atualizadas no corpo da requisição!")
            @RequestBody RatingDTO ratingAtualizado){
        if (ratingService.listarRatingPorID(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ID digitado não foi encontrado! ID: " + id);
        }
        RatingDTO ratingDTO = ratingService.atualizarRating(id, ratingAtualizado);
        return ResponseEntity.ok("A avaliação foi atualizada com sucesso! \nNome: " + ratingDTO.getGame() + " ID: " + ratingDTO.getId());
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta a avaliação pelo seu ID", description = "Essa rota tem a funçao de deletar a avaliação pelo id digitado")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "A avaliação foi deletada com sucesso!"),
            @ApiResponse (responseCode = "404",description = "A avaliação não foi deletada!")
    })
    public ResponseEntity<String> deletarRating(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id){
       RatingDTO ratingDTO = ratingService.listarRatingPorID(id);
       if (ratingDTO != null){
           ratingService.deletarRating(ratingDTO.getId());
           return ResponseEntity.ok("O id: (ID) "+id+" foi deletado com sucesso!");
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id: (ID) "+id+" não foi encontrado!");
       }
    }
}
