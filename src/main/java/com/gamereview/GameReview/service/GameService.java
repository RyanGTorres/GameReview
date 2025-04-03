package com.gamereview.GameReview.service;

import com.gamereview.GameReview.dto.GameDTO;
import com.gamereview.GameReview.mapper.GameMapper;
import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private GameRepository gameRepository;
    private GameMapper gameMapper;

    public GameService(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    public List<GameModel> listarGame(){
        return gameRepository.findAll();
    }

    public GameModel listarGamePorID(Long id){
        Optional<GameModel>gameModel = gameRepository.findById(id);
        return gameModel.orElse(null);
    }

    public GameDTO criarGame(GameDTO gameDTO){
        GameModel game = gameMapper.map(gameDTO);
        game = gameRepository.save(game);
        return gameMapper.map(game);
    }

    public GameModel atualizarGame(Long id, GameModel gameAtualizado){
        if (gameRepository.existsById(id)){
            gameAtualizado.setId(id);
            return gameRepository.save(gameAtualizado);
        }
        return null;
    }

    public void deletarGame(Long id){
        gameRepository.deleteById(id);
    }
}
