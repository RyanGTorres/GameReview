package com.gamereview.GameReview.service;

import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameModel> listarGame(){
        return gameRepository.findAll();
    }

}
