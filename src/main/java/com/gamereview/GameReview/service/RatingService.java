package com.gamereview.GameReview.service;

import com.gamereview.GameReview.dto.RatingDTO;
import com.gamereview.GameReview.mapper.GameMapper;
import com.gamereview.GameReview.mapper.RatingMapper;
import com.gamereview.GameReview.model.DeveloperModel;
import com.gamereview.GameReview.model.RatingModel;
import com.gamereview.GameReview.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingService {
    private RatingRepository ratingRepository;
    private RatingMapper ratingMapper;


    public RatingService(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    public List<RatingDTO> listarRating(){
        List<RatingModel> ratingModels = ratingRepository.findAll();
        return ratingModels.stream()
                .map(ratingMapper::mapToDTO)
                .collect(Collectors.toList());

    }

    public RatingDTO listaRatingPorID(Long id){
        Optional<RatingModel> ratingModel = ratingRepository.findById(id);
        return ratingModel.map(ratingMapper::mapToDTO).orElse(null);
    }

    public RatingDTO criarRating(RatingDTO ratingDTO){
        RatingModel ratingModel = ratingMapper.mapToModel(ratingDTO);
        ratingModel = ratingRepository.save(ratingModel);
        return ratingMapper.mapToDTO(ratingModel);
    }

    public RatingDTO atualizarRating(Long id, RatingDTO ratingDTO){
        Optional<RatingModel> ratingModel = ratingRepository.findById(id);
        if (ratingModel.isPresent()){
            RatingModel ratingAtualizado = ratingMapper.mapToModel(ratingDTO);
            ratingAtualizado.setId(id);
            RatingModel developerSalvo = ratingRepository.save(ratingAtualizado);
            return ratingMapper.mapToDTO(developerSalvo);
        }
        return null;
    }

    public void deletarRating(Long id){
        ratingRepository.deleteById(id);
    }
}
