package com.gamereview.GameReview.service;

import com.gamereview.GameReview.dto.RatingDTO;
import com.gamereview.GameReview.mapper.GameMapper;
import com.gamereview.GameReview.mapper.RatingMapper;
import com.gamereview.GameReview.model.RatingModel;
import com.gamereview.GameReview.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private RatingRepository ratingRepository;
    private RatingMapper ratingMapper;


    public RatingService(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    public List<RatingModel> listarRating(){
        return ratingRepository.findAll();
    }

    public RatingModel listaRatingPorID(Long id){
        Optional<RatingModel> ratingModel = ratingRepository.findById(id);
        return ratingModel.orElse(null);
    }
    public RatingDTO criarRating(RatingDTO ratingDTO){
        RatingModel ratingModel = ratingMapper.mapToModel(ratingDTO);
        ratingModel = ratingRepository.save(ratingModel);
        return ratingMapper.mapToDTO(ratingModel);
    }

    public RatingModel atualizarRating(Long id, RatingModel ratingAtualizado){
        if (ratingRepository.existsById(id)){
            ratingAtualizado.setId(id);
            return ratingRepository.save(ratingAtualizado);
        }
        return null;
    }

    public void deletarRating(Long id){
        ratingRepository.deleteById(id);
    }
}
