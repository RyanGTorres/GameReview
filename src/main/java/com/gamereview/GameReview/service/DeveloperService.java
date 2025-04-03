package com.gamereview.GameReview.service;

import com.gamereview.GameReview.model.DeveloperModel;
import com.gamereview.GameReview.repository.DeveloperRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService {
    private DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<DeveloperModel> listarDeveloper(){
        return developerRepository.findAll();
    }

    public DeveloperModel listarDeveloperPorID(Long id){
        Optional<DeveloperModel> developerModel = developerRepository.findById(id);
        return developerModel.orElse(null);
    }

    public DeveloperModel criarDeveloper(DeveloperModel developer){
        return developerRepository.save(developer);
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
