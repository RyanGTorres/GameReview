package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.dto.RatingDTO;
import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.model.RatingModel;
import com.gamereview.GameReview.service.RatingService;
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
    public RatingDTO criarRating(@RequestBody RatingDTO rating){
        return ratingService.criarRating(rating);
    }

    //GET ALL
    @GetMapping("/listar")
    public List<RatingModel> listarRating(){
        return ratingService.listarRating();
    }

    @GetMapping("/listar/{id}")
    public RatingModel listarRatingPorID(@PathVariable Long id){
        return ratingService.listaRatingPorID(id);
    }

    @PutMapping("/atualizar/{id}")
    public RatingModel atualizarRatingPorId(@PathVariable Long id, @RequestBody RatingModel ratingAtualizado){
        return ratingService.atualizarRating(id, ratingAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarRating(@PathVariable Long id){
        ratingService.deletarRating(id);
    }
}
