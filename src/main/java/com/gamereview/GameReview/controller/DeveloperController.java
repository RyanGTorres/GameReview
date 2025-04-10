package com.gamereview.GameReview.controller;

import com.gamereview.GameReview.dto.DeveloperDTO;
import com.gamereview.GameReview.service.DeveloperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Cria uma desenvolvedora", description = "Essa rota cria uma desenvolvedora para ser associada e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Sua desenvolvedora foi registrada com sucesso!"),
            @ApiResponse (responseCode = "400",description = "Erro ao registrar sua desenvolvedora!")
    })
    public ResponseEntity<String> criarDeveloper(
            @Parameter(description = "Usuario insere os dados da avaliação para serem criados no corpo da requisição!")
            @RequestBody DeveloperDTO developer){
        DeveloperDTO developerDTO = developerService.criarDeveloper(developer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("A desenvolvedora foi criada com sucesso!");
    }

    //GET ALL
    @GetMapping("/listar")
    @Operation(summary = "Lista todos as desenvolvedora criadas", description = "Essa rota tem a funçao de listar todas as desenvolvedora e exibir essa lista")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "Mostra todas a lista de desenvolvedora!")
    })
    public ResponseEntity<List<DeveloperDTO>> listarDeveloper(){
        List<DeveloperDTO> developerDTO = developerService.listarDeveloper();
        return ResponseEntity.ok(developerDTO);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista a desenvolvedora pelo seu ID", description = "Essa rota tem a funçao de listar uma desenvolvedora pelo id e mostrar ao usuario")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "A desenvolvedora foi listada com sucesso!"),
            @ApiResponse (responseCode = "404",description = "A desenvolvedora não foi listada!")
    })
    public ResponseEntity<?> listarDeveloperPorID(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id){
        DeveloperDTO developerDTO = developerService.listarDeveloperPorID(id);
        if (developerDTO == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O id "+id+" da avaliação não foi encontrado!");
        }
        return ResponseEntity.ok(developerDTO);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza a desenvolvedora pelo seu ID", description = "Essa rota tem a funçao de alterar a desenvolvedora pelo id")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "A desenvolvedora foi alterada com sucesso!"),
            @ApiResponse (responseCode = "404",description = "A desenvolvedora não foi alterado!")
    })
    public ResponseEntity<String> atualizarDevelope(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario insere os dados da desenvolvedora para ser atualizadas no corpo da requisição!")
            @RequestBody DeveloperDTO developerAtualizado){

        if (developerService.listarDeveloperPorID(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O id "+id+" da avaliação não foi encontrado!");
        }
        DeveloperDTO developerDTO = developerService.atualizarDeveloper(id, developerAtualizado);
        return ResponseEntity.ok("A desenvolvedor foi atualizada com sucesso! \n Nome: "+developerDTO.getName()+" ID: "+developerDTO.getId());
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta a desenvolvedora pelo seu ID", description = "Essa rota tem a funçao de deletar a desenvolvedora pelo id digitado")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200",description = "A desenvolvedora foi deletada com sucesso!"),
            @ApiResponse (responseCode = "404",description = "A desenvolvedora não foi deletada!")
    })
    public ResponseEntity<String> deletarDeveloper(
            @Parameter(description = "Usuario insere o ID no caminho da requisição")
            @PathVariable Long id){
       if (developerService.listarDeveloperPorID(id) != null){
           developerService.deletarDeveloper(id);
           return ResponseEntity.ok("O id: "+id+" foi deletado com sucesso!");
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND)
               .body("O id: (ID) "+id+" não foi encontrado!");

    }

}
