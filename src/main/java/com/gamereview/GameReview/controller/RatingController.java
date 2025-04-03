package com.gamereview.GameReview.controller;

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
    public RatingModel criarRating(@RequestBody RatingModel rating){
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

    @PutMapping("/atualizarID")
    public String atualizarRatingPorId(){
        return "Atualizar Rating ID";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarRating(@PathVariable Long id){
        ratingService.deletarRating(id);
    }
}
