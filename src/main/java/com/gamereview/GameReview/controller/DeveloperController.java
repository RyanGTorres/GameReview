package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.model.DeveloperModel;
import com.gamereview.GameReview.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("developer")
public class DeveloperController {

    private DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping("/criar")
    public String criarDeveloper(){
        return "Developer criado!";
    }

    //GET ALL
    @GetMapping("/todos")
    public List<DeveloperModel> listarDeveloper(){
        return developerService.listarDeveloper();
    }

    @GetMapping("/todosID")
    public String mostrarTodosOsDeveloperPorId(){
        return "Developer Mostrado por id!";
    }

    @PutMapping("/atualizarID")
    public String atualizarDeveloperPorId(){
        return "Atualizar Developer ID";
    }

    @DeleteMapping("/deletarID")
    public String deletarDeveloperPorId(){
        return "deletar Developer por id!";
    }

}
