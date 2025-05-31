package com.gamereview.GameReview.mapper;

import com.gamereview.GameReview.dto.RatingDTO;
import com.gamereview.GameReview.model.RatingModel;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public RatingModel mapToModel(RatingDTO ratingDTO){
        RatingModel ratingModel = new RatingModel();
        ratingModel.setId(ratingDTO.getId());
        ratingModel.setGame(ratingDTO.getGame());
        ratingModel.setRealeseDate(ratingDTO.getReleaseDate());
        ratingModel.setNote(ratingDTO.getNote());
        ratingModel.setComment(ratingDTO.getComment());

        return ratingModel;
    }

    public RatingDTO mapToDTO(RatingModel ratingModel){
        RatingDTO ratingDTO = new RatingDTO();

        ratingDTO.setId(ratingModel.getId());
        ratingDTO.setGame(ratingModel.getGame());
        ratingDTO.setReleaseDate(ratingModel.getRealeseDate());
        ratingDTO.setComment(ratingModel.getComment());
        ratingDTO.setNote(ratingModel.getNote());

        return  ratingDTO;
    }
}
