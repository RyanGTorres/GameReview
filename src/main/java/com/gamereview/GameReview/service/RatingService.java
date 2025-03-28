package com.gamereview.GameReview.service;

import com.gamereview.GameReview.model.RatingModel;
import com.gamereview.GameReview.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    private RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<RatingModel> listarRating(){
        return ratingRepository.findAll();
    }
}
