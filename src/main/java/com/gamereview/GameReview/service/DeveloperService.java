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
import java.util.stream.Collectors;

@Service
public class DeveloperService {
    private DeveloperRepository developerRepository;
    private DeveloperMapper developerMapper;

    public DeveloperService(DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.developerMapper = developerMapper;
    }

    public List<DeveloperDTO> listarDeveloper(){
        List<DeveloperModel> developerModels = developerRepository.findAll();
        return developerModels.stream()
                .map(developerMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public DeveloperDTO listarDeveloperPorID(Long id){
        Optional<DeveloperModel> developerModel = developerRepository.findById(id);
        return developerModel.map(developerMapper::mapToDTO).orElse(null);
    }

    public DeveloperDTO criarDeveloper(DeveloperDTO developerDTO){
        DeveloperModel dev = developerMapper.mapToModel(developerDTO);
        dev = developerRepository.save(dev);
        return developerMapper.mapToDTO(dev);
    }


    public DeveloperDTO atualizarDeveloper(Long id, DeveloperDTO developerDTO){
        Optional<DeveloperModel>developerExistente = developerRepository.findById(id);
        if (developerExistente.isPresent()){
            DeveloperModel developerAtualizado = developerMapper.mapToModel(developerDTO);
            developerAtualizado.setId(id);
            DeveloperModel developerSalvo = developerRepository.save(developerAtualizado);
            return developerMapper.mapToDTO(developerSalvo);
        }
        return null;
    }

    public void deletarDeveloper(Long id){
        developerRepository.deleteById(id);
    }

    public DeveloperRepository getDeveloperRepository() {
        return developerRepository;
    }

    public void setDeveloperRepository(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public DeveloperMapper getDeveloperMapper() {
        return developerMapper;
    }

    public void setDeveloperMapper(DeveloperMapper developerMapper) {
        this.developerMapper = developerMapper;
    }
}
