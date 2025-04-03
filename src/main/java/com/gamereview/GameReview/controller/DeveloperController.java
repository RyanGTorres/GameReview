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
    public DeveloperModel criarDeveloper(@RequestBody DeveloperModel developer){
        return developerService.criarDeveloper(developer);
    }

    //GET ALL
    @GetMapping("/listar")
    public List<DeveloperModel> listarDeveloper(){
        return developerService.listarDeveloper();
    }

    @GetMapping("/listar/{id}")
    public DeveloperModel listarDeveloperPorID(@PathVariable Long id){
        return developerService.listarDeveloperPorID(id);
    }

    @PutMapping("/atualizar/{id}")
    public DeveloperModel atualizarDevelope(@PathVariable Long id, @RequestBody DeveloperModel developerAtualizado){
        return developerService.atualizarDeveloper(id, developerAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarDeveloper(@PathVariable Long id){
        developerService.deletarDeveloper(id);
    }

}
