package com.gamereview.GameReview.mapper;

import com.gamereview.GameReview.dto.GameDTO;
import com.gamereview.GameReview.model.GameModel;
import org.springframework.stereotype.Component;

@Component
public class GameMapper {
    public GameModel map(GameDTO gameDTO){
        GameModel gameModel = new GameModel();
        gameModel.setId(gameDTO.getId());
        gameModel.setName(gameDTO.getName());
        gameModel.setDeveloper(gameDTO.getDeveloper());
        gameModel.setGender(gameDTO.getGender());
        gameModel.setPlatform(gameDTO.getPlatform());
        gameModel.setRealeseDate(gameDTO.getRealeseDate());
        gameModel.setIndicativeRating(gameDTO.getIndicativeRating());
        gameModel.setRatings(gameDTO.getRatings());

        return gameModel;
    }

    public GameDTO map(GameModel gameModel){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setId(gameModel.getId());
        gameDTO.setName(gameModel.getName());
        gameDTO.setDeveloper(gameModel.getDeveloper());
        gameDTO.setGender(gameModel.getGender());
        gameDTO.setPlatform(gameModel.getPlatform());
        gameDTO.setRealeseDate(gameDTO.getRealeseDate());
        gameDTO.setIndicativeRating(gameModel.getIndicativeRating());
        gameDTO.setRatings(gameModel.getRatings());

        return gameDTO;
    }

}
