package com.gamereview.GameReview.service;

import com.gamereview.GameReview.model.GameIdeaModel;
import com.gamereview.GameReview.repository.GameIdeaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameIdeaService {

    private GameIdeaRepository gameIdeaRepository;

    public GameIdeaService(GameIdeaRepository gameIdeaRepository) {
        this.gameIdeaRepository = gameIdeaRepository;
    }

    public GameIdeaModel salvarIndicacao(GameIdeaModel gameIdeaModel){
        return gameIdeaRepository.save(gameIdeaModel);
    }

    public List<GameIdeaModel> listarIndicacao( ){
        return gameIdeaRepository.findAll();
    }

    public Optional<GameIdeaModel> listarPorID(Long id){
        return gameIdeaRepository.findById(id);
    }

    public GameIdeaModel atualizarIndicacao(GameIdeaModel gameIdeaModel, Long id){

        if (gameIdeaRepository.existsById(id)){
        gameIdeaModel.setId(id);
        return gameIdeaRepository.save(gameIdeaModel);
        }
        return null;
    }

    public void deletarIndicacao(Long id){
       gameIdeaRepository.deleteById(id);
    }
}
