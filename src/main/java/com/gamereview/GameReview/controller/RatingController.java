package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.dto.GameDTO;
import com.gamereview.GameReview.dto.RatingDTO;
import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.model.RatingModel;
import com.gamereview.GameReview.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<String> criarRating(@RequestBody RatingDTO rating){
        RatingDTO ratingDTO = ratingService.criarRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sua avaliação foi adicionada com sucesso! Nome: "+ratingDTO.getGame() + "ID: (ID) "+ratingDTO.getId());
    }

    //GET ALL
    @GetMapping("/listar")
    public ResponseEntity<List<RatingDTO>> listarRating(){
         List<RatingDTO> ratingDTO = ratingService.listarRating();
         return ResponseEntity.ok(ratingDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarRatingPorID(@PathVariable Long id){
        RatingDTO ratingDTO = ratingService.listarRatingPorID(id);
        if (ratingDTO != null){
            return ResponseEntity.ok(ratingDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id "+id+" da avaliação não foi encontrado!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarRatingPorId(@PathVariable Long id, @RequestBody RatingDTO ratingAtualizado){
        if (ratingService.listarRatingPorID(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ID digitado não foi encontrado! ID: " + id);
        }
        RatingDTO ratingDTO = ratingService.atualizarRating(id, ratingAtualizado);
        return ResponseEntity.ok("A avaliação foi atualizada com sucesso! \nNome: " + ratingDTO.getGame() + " ID: " + ratingDTO.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarRating(@PathVariable Long id){
       RatingDTO ratingDTO = ratingService.listarRatingPorID(id);
       if (ratingDTO != null){
           return ResponseEntity.ok("O id: (ID) "+id+" foi deletado com sucesso!");
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id: (ID) "+id+" não foi encontrado!");
       }
    }
}
