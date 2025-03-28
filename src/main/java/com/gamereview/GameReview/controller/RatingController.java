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
    public String criarRating(){
        return "Rating criado!";
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

    @DeleteMapping("/deletarID")
    public String deletarRatingPorId(){
        return "deletar Rating por id!";
    }
}
