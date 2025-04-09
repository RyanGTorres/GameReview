package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.dto.DeveloperDTO;
import com.gamereview.GameReview.dto.RatingDTO;
import com.gamereview.GameReview.model.DeveloperModel;
import com.gamereview.GameReview.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarDeveloper(@RequestBody DeveloperDTO developer){
        DeveloperDTO developerDTO = developerService.criarDeveloper(developer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A desenvolvedora foi criada com sucesso!");
    }

    //GET ALL
    @GetMapping("/listar")
    public ResponseEntity<List<DeveloperDTO>> listarDeveloper(){
        List<DeveloperDTO> developerDTO = developerService.listarDeveloper();
        return ResponseEntity.ok(developerDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarDeveloperPorID(@PathVariable Long id){
        DeveloperDTO developerDTO = developerService.listarDeveloperPorID(id);
        if (developerDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O id "+id+" da avaliação não foi encontrado!");
        }
        return ResponseEntity.ok(developerDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarDevelope(@PathVariable Long id, @RequestBody DeveloperDTO developerAtualizado){

        if (developerService.listarDeveloperPorID(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O id "+id+" da avaliação não foi encontrado!");
        }
        DeveloperDTO developerDTO = developerService.atualizarDeveloper(id, developerAtualizado);
        return ResponseEntity.ok("A desenvolvedor foi atualizada com sucesso! \n Nome: "+developerDTO.getName()+" ID: "+developerDTO.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarDeveloper(@PathVariable Long id){
       if (developerService.listarDeveloperPorID(id) != null){
           developerService.deletarDeveloper(id);
           return ResponseEntity.ok("O id: "+id+" foi deletado com sucesso!");
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("O id: (ID) "+id+" não foi encontrado!");

    }

}
