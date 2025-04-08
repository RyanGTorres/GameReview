package com.gamereview.GameReview.service;

import com.gamereview.GameReview.dto.GameDTO;
import com.gamereview.GameReview.mapper.GameMapper;
import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameService {
    private GameRepository gameRepository;
    private GameMapper gameMapper;

    public GameService(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    public List<GameDTO> listarGame(){
        List<GameModel> games = gameRepository.findAll();
        return games.stream()
                .map(gameMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public GameDTO listarGamePorID(Long id){
        Optional<GameModel>gameporID = gameRepository.findById(id);
        return gameporID.map(gameMapper::mapToDTO).orElse(null);
    }

    public GameDTO criarGame(GameDTO gameDTO){
        GameModel game = gameMapper.mapToModel(gameDTO);
        game = gameRepository.save(game);
        return gameMapper.mapToDTO(game);
    }

    public GameDTO atualizarGame(Long id, GameDTO gameDTO){
        Optional<GameModel>gameExistente = gameRepository.findById(id);
        if (gameExistente.isPresent()){
            GameModel gameAtualizado = gameMapper.mapToModel(gameDTO);
            gameAtualizado.setId(id);
            GameModel gameSalvo = gameRepository.save(gameAtualizado);
            return gameMapper.mapToDTO(gameSalvo);
        }
        return null;
    }

    public void deletarGame(Long id){
        gameRepository.deleteById(id);
    }
}
