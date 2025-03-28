package com.gamereview.GameReview.service;

import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameModel> listarGame(){
        return gameRepository.findAll();
    }

    public GameModel listarGamePorID(Long id){
        Optional<GameModel>gameModel = gameRepository.findById(id);
        return gameModel.orElse(null);
    }

}
