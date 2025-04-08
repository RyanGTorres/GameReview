package com.gamereview.GameReview.service;

import com.gamereview.GameReview.dto.DeveloperDTO;
import com.gamereview.GameReview.dto.GameDTO;
import com.gamereview.GameReview.mapper.DeveloperMapper;
import com.gamereview.GameReview.model.DeveloperModel;
import com.gamereview.GameReview.model.GameModel;
import com.gamereview.GameReview.repository.DeveloperRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {
    private DeveloperRepository developerRepository;
    private DeveloperMapper developerMapper;

    public DeveloperService(DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.developerMapper = developerMapper;
    }

    public List<DeveloperModel> listarDeveloper(){
        return developerRepository.findAll();
    }

    public DeveloperModel listarDeveloperPorID(Long id){
        Optional<DeveloperModel> developerModel = developerRepository.findById(id);
        return developerModel.orElse(null);
    }

    public DeveloperDTO criarDeveloper(DeveloperDTO developerDTO){
        DeveloperModel dev = developerMapper.mapToModel(developerDTO);
        dev = developerRepository.save(dev);
        return developerMapper.mapToDTO(dev);
    }


    public DeveloperModel atualizarDeveloper(Long id, DeveloperModel developerAtualizado){
        if(developerRepository.existsById(id)){
            developerAtualizado.setId(id);
            return developerRepository.save(developerAtualizado);
        }
        return null;
    }

    public void deletarDeveloper(Long id){
        developerRepository.deleteById(id);
    }
}
