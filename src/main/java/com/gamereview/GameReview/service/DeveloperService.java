package com.gamereview.GameReview.service;

import com.gamereview.GameReview.model.DeveloperModel;
import com.gamereview.GameReview.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {
    private DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public List<DeveloperModel> listarDeveloper(){
        return developerRepository.findAll();
    }
}
